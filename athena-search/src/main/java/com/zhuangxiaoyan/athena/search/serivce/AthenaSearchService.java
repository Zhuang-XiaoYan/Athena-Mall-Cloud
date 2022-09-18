package com.zhuangxiaoyan.athena.search.serivce;

import com.zhuangxiaoyan.athena.search.vo.SearchParamVo;
import com.zhuangxiaoyan.athena.search.vo.SearchResultVo;

/**
 * @Description MallSearchService
 * @Date 2022/8/2 9:22
 *@author: xjl
 */
public interface AthenaSearchService {

    /**
     * @param param 检索的所有参数
     * @return  返回检索的结果，里面包含页面需要的所有信息
     */
    SearchResultVo search(SearchParamVo param);
}
