package com.zhuangxiaoyan.athena.ware.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description PurchaseDoneVo
 * @date: 2022/7/31 0:07
 * @author: xjl
 */

@Data
public class PurchaseDoneVo {

    @NotNull(message = "id不允许为空")
    private Long id;

    private List<PurchaseItemDoneVo> items;

}
