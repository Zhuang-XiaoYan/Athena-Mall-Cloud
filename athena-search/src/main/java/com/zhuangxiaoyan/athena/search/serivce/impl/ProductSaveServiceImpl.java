package com.zhuangxiaoyan.athena.search.serivce.impl;

import com.alibaba.fastjson.JSON;
import com.zhuangxiaoyan.athena.search.config.AthenaElasticSearchConfig;
import com.zhuangxiaoyan.athena.search.constant.ElasticsearchConstant;
import com.zhuangxiaoyan.athena.search.serivce.ProductSaveService;
import com.zhuangxiaoyan.athena.search.to.SkuEsModelTo;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description ProductSaveServiceImpl
 * @Date 2022/8/2 9:25
 * @Created by xjl
 */
@Slf4j
@Service
public class ProductSaveServiceImpl implements ProductSaveService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * @description 商品上架功能，就是保存到的es中提供一个可以检索的功能
     * @param: skuEsModelTos
     * @date: 2022/8/2 9:25
     * @return: void
     * @author: xjl
     */
    @Override
    public Boolean productStateUp(List<SkuEsModelTo> skuEsModelTos) throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        for (SkuEsModelTo model:skuEsModelTos ) {
            IndexRequest indexRequest = new IndexRequest(ElasticsearchConstant.PRODUCT_INDEX);
            indexRequest.id(model.getSkuId().toString());
            String s = JSON.toJSONString(model);
            indexRequest.source(s, XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, AthenaElasticSearchConfig.COMMON_OPTIONS);
        //TODO 如果批量错误
        boolean hasFailures = bulk.hasFailures();
        List<String> collect = Arrays.asList(bulk.getItems()).stream().map(item -> {
            return item.getId();
        }).collect(Collectors.toList());
        log.info("商品上架完成：{}",collect);
        return hasFailures;
    }
}
