package com.zhuangxiaoyan.athena.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.coupon.entity.HomeSubjectEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 * @date: 2022/7/28 16:31
 * @author: xjl
*/
public interface HomeSubjectService extends IService<HomeSubjectEntity> {

    /**
     * @description queryPage
      * @param: params
     * @date: 2022/7/28 16:32
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    PageUtils queryPage(Map<String, Object> params);
}

