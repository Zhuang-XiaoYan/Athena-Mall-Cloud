package com.zhuangxiaoyan.athena.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @description MergeVo传输对象
 * @param: null
 * @date: 2022/7/26 23:45
 * @return:
 * @author: xjl
 */

@Data
public class MergeVo {
    /**
     * @description 整单id
     */
    private Long purchaseId;
    /**
     * @description 合并的项
     */
    private List<Long> items;

}
