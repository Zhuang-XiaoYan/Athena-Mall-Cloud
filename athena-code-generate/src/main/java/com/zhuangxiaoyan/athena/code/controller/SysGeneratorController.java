package com.zhuangxiaoyan.athena.code.controller;

import com.zhuangxiaoyan.athena.code.service.SysGeneratorService;
import com.zhuangxiaoyan.athena.code.service.utils.PageUtils;
import com.zhuangxiaoyan.athena.code.service.utils.Query;
import com.zhuangxiaoyan.athena.code.service.utils.Result;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @description 代码生成器controller层
 * @date: 2022/7/29 12:49
 * @author: xjl
 */
@Controller
@RequestMapping("/sys/generator")
public class SysGeneratorController {

    @Autowired
    private SysGeneratorService sysGeneratorService;

    /**
     * @description 查询所有的列表
     * @param: params
     * @date: 2022/7/29 12:51
     * @return: com.zhuangxiaoyan.athena.code.utils.Result
     * @author: xjl
     */
    @ResponseBody
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils pageUtil = sysGeneratorService.queryList(new Query(params));
        return Result.ok().put("page", pageUtil);
    }

    /**
     * @description 生成代码
     * @param: tables
     * @param: response
     * @date: 2022/7/29 12:52
     * @return: void
     * @author: xjl
     */
    @RequestMapping("/code")
    public void code(String tables, HttpServletResponse response) throws IOException {
        byte[] data = sysGeneratorService.generatorCode(tables.split(","));
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"Athena.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
}
