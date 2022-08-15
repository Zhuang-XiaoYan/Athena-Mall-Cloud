package com.zhuangxiaoyan.athena.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.product.dao.CategoryDao;
import com.zhuangxiaoyan.athena.product.entity.CategoryEntity;
import com.zhuangxiaoyan.athena.product.service.CategoryBrandRelationService;
import com.zhuangxiaoyan.athena.product.service.CategoryService;
import com.zhuangxiaoyan.athena.product.vo.Catelog2Vo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @description CategoryServiceImpl
 * @date: 2022/7/28 14:13
 * @author: xjl
 */
@Slf4j
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedissonClient redissonClient;

    /**
     * @description queryPage()
     * @param: params
     * @date: 2022/7/28 14:10
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(new Query<CategoryEntity>().getPage(params), new QueryWrapper<CategoryEntity>());
        return new PageUtils(page);
    }

    /**
     * @description 查询出所有的分类以及子分类，以及树形结构
     * @param:
     * @date: 2022/3/13 17:38
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.CategoryEntity>
     * @author: xjl
     */
    @Override
    public List<CategoryEntity> listWithTree() {
        // 查询出所有的分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        // 组装成为的父子结构返回 找到的所有的以及分类
        // 一级分类
        List<CategoryEntity> level1Menus = entities.stream().filter(categoryEntity -> categoryEntity.getParentCid() == 0).map((menu) -> {
            menu.setChildren(getChildrens(menu, entities));
            return menu;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return level1Menus;
    }

    /**
     * @description 递归查找所有的子分类
     * @param: root
     * @param: all
     * @date: 2022/7/28 14:11
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.CategoryEntity>
     * @author: xjl
     */
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals(root.getCatId());
        }).map(categoryEntity -> {
            // 1找到子菜单
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            // 进行排序处理
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }

    /**
     * @description 检查的删除的菜单 是否被其他地方引用
     * @param: asList
     * @date: 2022/3/19 13:57
     * @return: void
     * @author: xjl
     */
    @Override
    public void removeMenuByIds(List<Long> asList) {
        //逻辑删除 一般不做删除
        baseMapper.deleteBatchIds(asList);
    }

    /**
     * @description 查询的CateglogId的所有的路径
     * @param: null
     * @date: 2022/7/28 14:11
     * @return:
     * @author: xjl
     */
    @Override
    public Long[] findCateglogPath(Long categoryId) {
        List<Long> paths = new ArrayList<>();
        List<Long> parentPath = findParentPath(categoryId, paths);
        Collections.reverse(parentPath);
        return parentPath.toArray(new Long[parentPath.size()]);
    }

    /**
     * @description findParentPath()
     * @param: categoryId
     * @param: paths
     * @date: 2022/7/28 14:11
     * @return: java.util.List<java.lang.Long>
     * @author: xjl
     */
    private List<Long> findParentPath(Long categoryId, List<Long> paths) {
        // 收集当前的节点的id数据
        paths.add(categoryId);
        CategoryEntity byId = this.getById(categoryId);
        if (byId.getParentCid() != 0) {
            findParentPath(byId.getParentCid(), paths);
        }
        return paths;
    }

    /**
     * @description 级联更新所有的关联数据
     * CacheEvict 缓存失效
     * @param: category
     * @date: 2022/7/23 11:27
     * @return: void
     * @author: xjl
     */
//    @Caching(evict = {
//            @CacheEvict(value = "category", key = "'queryOneCategory'"),
//            @CacheEvict(value = "category", key = "'getCatalogJsonFromDb'")
//    })
    @CacheEvict(value = "category", allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        // 级联更新
        categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());
    }

    /**
     * @description 查询的商品的一级分类
     * 表示当前的结果的需要缓存 如果缓存中有 方法都不调用,如果缓存中没有，则会调用方法，最后将方法的结果放入缓存中 每一个缓存的数据 指定缓存的分区 按照业务类型分区
     * @param:
     * @date: 2022/8/3 23:20
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.CategoryEntity>
     * @author: xjl
     */
    @Cacheable(value = {"category"}, key = "#root.method.name")
    @Override
    public List<CategoryEntity> queryOneCategory() {
        System.out.println("查询了一级菜单的分类的…………");
        List<CategoryEntity> categoryEntities = this.baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_cid", 0));
        return categoryEntities;
    }

    /**
     * @description 查询的父标签的id
     * @param: selectList
     * @param: parentCid
     * @date: 2022/8/13 10:18
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.CategoryEntity>
     * @author: xjl
     */
    @Cacheable(value = {"category"}, key = "#root.method.name")
    public List<CategoryEntity> getParent_cid(List<CategoryEntity> selectList, Long parentCid) {
        System.out.println("查询的父类的Id…………");
        List<CategoryEntity> categoryEntities = selectList.stream().filter(item -> item.getParentCid().equals(parentCid)).collect(Collectors.toList());
        return categoryEntities;
    }

    /**
     * @description 通过Db获取的目录的文件
     * @param: 使用的synchronized
     * @date: 2022/8/13 10:14
     * @return: java.util.Map<java.lang.String, java.util.List < com.zhuangxiaoyan.athena.product.vo.Catelog2Vo>>
     * @author: xjl
     */
    @Cacheable(value = "category", key = "#root.method.name")
    @Override
    public Map<String, List<Catelog2Vo>> getCatalogJsonFromDb() {
        //得到锁以后，我们应该再去缓存中确定一次，如果没有才需要继续查询
        String catalogJson = stringRedisTemplate.opsForValue().get("catalogJson");
        if (!StringUtils.isEmpty(catalogJson)) {
            //缓存不为空直接返回
            Map<String, List<Catelog2Vo>> result = JSON.parseObject(catalogJson, new TypeReference<Map<String, List<Catelog2Vo>>>() {});
            return result;
        }
        System.out.println("查询了数据库");
        List<CategoryEntity> selectList = this.baseMapper.selectList(null);
        //1、查出所有分类
        //1、1）查出所有一级分类
        List<CategoryEntity> level1Categorys = getParent_cid(selectList, 0L);
        //封装数据
        Map<String, List<Catelog2Vo>> parentCid = level1Categorys.stream().collect(Collectors.toMap(k -> k.getCatId().toString(), v -> {
            //1、每一个的一级分类,查到这个一级分类的二级分类
            List<CategoryEntity> categoryEntities = getParent_cid(selectList, v.getCatId());
            //2、封装上面的结果
            List<Catelog2Vo> catelog2Vos = null;
            if (categoryEntities != null) {
                catelog2Vos = categoryEntities.stream().map(l2 -> {
                    Catelog2Vo catelog2Vo = new Catelog2Vo(v.getCatId().toString(), null, l2.getCatId().toString(), l2.getName().toString());
                    //1、找当前二级分类的三级分类封装成vo
                    List<CategoryEntity> level3Catelog = getParent_cid(selectList, l2.getCatId());
                    if (level3Catelog != null) {
                        List<Catelog2Vo.Category3Vo> category3Vos = level3Catelog.stream().map(l3 -> {
                            //2、封装成指定格式
                            Catelog2Vo.Category3Vo category3Vo = new Catelog2Vo.Category3Vo(l2.getCatId().toString(), l3.getCatId().toString(), l3.getName());
                            return category3Vo;
                        }).collect(Collectors.toList());
                        catelog2Vo.setCatalog3List(category3Vos);
                    }
                    return catelog2Vo;
                }).collect(Collectors.toList());
            }
            return catelog2Vos;
        }));
        //3、将查到的数据放入缓存,将对象转为json
        String valueJson = JSON.toJSONString(parentCid);
        stringRedisTemplate.opsForValue().set("catalogJson", valueJson, 1, TimeUnit.DAYS);
        return parentCid;
    }

    /**
     * @description 通过redis获取的目录的文件
     * 1)、springboot2.0以后默认使用lettuce操作redis的客户端，它使用通信
     * 2)、lettuce的bug导致netty堆外内存溢出,可设置：-Dio.netty.maxDirectMemory
     * 解决方案：不能直接使用-Dio.netty.maxDirectMemory去调大堆外内存
     * 1)、升级lettuce客户端。
     * 2）、切换使用jedis
     * @param:
     * @date: 2022/8/13 10:14
     * @return: java.util.Map<java.lang.String, java.util.List < com.zhuangxiaoyan.athena.product.vo.Catelog2Vo>>
     * @author: xjl
     */
    @Override
    public Map<String, List<Catelog2Vo>> getCatalogJsonFromRedis() {
        // 添加空的结果:解决缓存穿透问题
        // 设置过期时间（添加随机值）:解决缓存雪崩问题
        // 加锁:解决缓存击穿问题
        //1、加入缓存逻辑,缓存中存的数据是json字符串
        String catalogJSON = stringRedisTemplate.opsForValue().get("catalogJSON");
        if (StringUtils.isEmpty(catalogJSON)) {
            log.info("缓存不命中，将要查询数据库……");
            //2、缓存中没有数据，查询数据库db
            Map<String, List<Catelog2Vo>> catalogJsonFromDb = getCatalogJsonFromDb();
            return catalogJsonFromDb;
        }
        log.info("缓存命中，直接返回数据……");
        //转为指定的对象
        Map<String, List<Catelog2Vo>> result = JSON.parseObject(catalogJSON, new TypeReference<Map<String, List<Catelog2Vo>>>() {});
        return result;
    }

    /**
     * @description 使用分布式锁的机制
     * @param:
     * @date: 2022/8/13 15:12
     * @return: java.util.Map<java.lang.String, java.util.List < com.zhuangxiaoyan.athena.product.vo.Catelog2Vo>>
     * @author: xjl
     */
    @Override
    public Map<String, List<Catelog2Vo>> getCatalogJsonFromDbWithRedisLock() {
        //1、占分布式锁。去redis占坑、设置过期时间必须和加锁是同步的，保证原子性（避免死锁）
        String Lockkey = "athena-RedisLock";
        String token = UUID.randomUUID().toString();
        Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent(Lockkey, token, 60, TimeUnit.SECONDS);
        if (lock) {
            System.out.println("获取分布式锁成功...");
            Map<String, List<Catelog2Vo>> dataFromDb = null;
            try {
                //加锁成功...执行业务
                dataFromDb = getCatalogJsonFromDb();
            } finally {
                String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
                //删除锁 执行的原子操作
                stringRedisTemplate.execute(new DefaultRedisScript<Long>(script, Long.class), Arrays.asList(Lockkey), token);
            }
            return dataFromDb;
        } else {
            System.out.println("获取分布式锁失败...等待重试...");
            //加锁失败...重试机制、休眠一百毫秒
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //自旋的方式
            return getCatalogJsonFromDbWithRedisLock();
        }
    }

    /**
     * @description 使用的是RedissonLock分布式锁
     * @param:
     * @date: 2022/8/13 17:30
     * @return: java.util.Map<java.lang.String, java.util.List < com.zhuangxiaoyan.athena.product.vo.Catelog2Vo>>
     * @author: xjl
     */
    @Override
    public Map<String, List<Catelog2Vo>> getCatalogJsonFromDbWithRedissonLock() {
        //1、占分布式锁。去redis占坑
        //（锁的粒度，越细越快:具体缓存的是某个数据，11号商品） product-11-lock
        // RLock catalogJsonLock = redissonClient.getLock("catalogJson-lock");
        // 创建读锁
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock("catalogJson-RedissonLock");
        RLock rLock = readWriteLock.readLock();
        Map<String, List<Catelog2Vo>> dataFromDb = null;
        try {
            rLock.lock();
            //加锁成功...执行业务
            dataFromDb = getCatalogJsonFromDb();
        } finally {
            rLock.unlock();
        }
        return dataFromDb;
    }
}