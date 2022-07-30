package com.zhuangxiaoyan.athena.code.exception;

import com.alibaba.fastjson.JSON;
import com.zhuangxiaoyan.athena.code.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description 异常处理器
 * @date: 2022/7/30 8:42
 * @author: xjl
*/
@Component
public class AthenaExceptionHandler implements HandlerExceptionResolver {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * @description resolveException
     * @param: request
     * @param: response
     * @param: handler
     * @param: ex
     * @date: 2022/7/29 13:12
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: xjl
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        Result r = new Result();
        try {
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("utf-8");

            if (ex instanceof AthenaException) {
                r.put("code", ((AthenaException) ex).getCode());
                r.put("msg", ex.getMessage());
            } else if (ex instanceof DuplicateKeyException) {
                r = Result.error("数据库中已存在该记录");
            } else {
                r = Result.error();
            }

            //记录异常日志
            logger.error(ex.getMessage(), ex);

            String json = JSON.toJSONString(r);
            response.getWriter().print(json);
        } catch (Exception e) {
            logger.error("RRExceptionHandler 异常处理失败", e);
        }
        return new ModelAndView();
    }
}
