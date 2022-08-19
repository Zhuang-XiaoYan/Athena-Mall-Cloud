package com.zhuangxiaoyan.athena.search.serivce.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.extension.api.R;
import com.zhuangxiaoyan.athena.search.config.AthenaElasticSearchConfig;
import com.zhuangxiaoyan.athena.search.constant.ElasticsearchConstant;
import com.zhuangxiaoyan.athena.search.fegin.ProductFeignService;
import com.zhuangxiaoyan.athena.search.serivce.AthenaSearchService;
import com.zhuangxiaoyan.athena.search.to.SkuEsModelTo;
import com.zhuangxiaoyan.athena.search.vo.AttrResponseVo;
import com.zhuangxiaoyan.athena.search.vo.SearchParamVo;
import com.zhuangxiaoyan.athena.search.vo.SearchResultVo;
import com.zhuangxiaoyan.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.NestedQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.nested.ParsedNested;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedLongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description MallSearchServiceImpl
 * @date: 2022/8/16 11:30
 * @author: xjl
 */

@Slf4j
@Service
public class AthenaSearchServiceImpl implements AthenaSearchService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Resource
    private ProductFeignService productFeignService;

    @Override
    public SearchResultVo search(SearchParamVo param) {
      return null;
    }
}
