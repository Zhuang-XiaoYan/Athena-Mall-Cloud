package com.zhuangxiaoyan.athena.ware.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.ware.dao.WareInfoDao;
import com.zhuangxiaoyan.athena.ware.entity.WareInfoEntity;
import com.zhuangxiaoyan.athena.ware.fegin.MemberFeignService;
import com.zhuangxiaoyan.athena.ware.service.WareInfoService;
import com.zhuangxiaoyan.athena.ware.vo.FareVo;
import com.zhuangxiaoyan.athena.ware.vo.MemberAddressVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import com.zhuangxiaoyan.common.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service("wareInfoService")
public class WareInfoServiceImpl extends ServiceImpl<WareInfoDao, WareInfoEntity> implements WareInfoService {

    @Autowired
    MemberFeignService memberFeignService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<WareInfoEntity> queryWrapper = new QueryWrapper<>();
        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {
            queryWrapper.eq("id", key).
                    or().like("name", key).
                    or().like("address", key).
                    or().like("areacode", key);
        }
        IPage<WareInfoEntity> page = this.page(new Query<WareInfoEntity>().getPage(params), queryWrapper);
        return new PageUtils(page);
    }

    @Override
    public FareVo getFare(Long addrId) {
        FareVo fareVo = new FareVo();
        Result result=memberFeignService.addressInfo(addrId);
        MemberAddressVo memberAddressVo = result.getData("memberReceiveAddress",new TypeReference<MemberAddressVo>() {});
        if (memberAddressVo!=null){
            String phone=memberAddressVo.getPhone();
            BigDecimal bigDecimal = new BigDecimal(phone.substring(phone.length() - 1, phone.length()));
            fareVo.setAddress(memberAddressVo);
            fareVo.setFare(bigDecimal);
            return fareVo;
        }
        return null;
    }

}