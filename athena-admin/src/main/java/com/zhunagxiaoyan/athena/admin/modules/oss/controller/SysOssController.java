

package com.zhunagxiaoyan.athena.admin.modules.oss.controller;

import com.google.gson.Gson;
import com.zhunagxiaoyan.athena.admin.common.exception.AthenaException;
import com.zhunagxiaoyan.athena.admin.common.utils.ConfigConstant;
import com.zhunagxiaoyan.athena.admin.common.utils.Constant;
import com.zhunagxiaoyan.athena.admin.common.utils.PageUtils;
import com.zhunagxiaoyan.athena.admin.common.utils.Result;
import com.zhunagxiaoyan.athena.admin.common.validator.group.AliyunGroup;
import com.zhunagxiaoyan.athena.admin.common.validator.group.QcloudGroup;
import com.zhunagxiaoyan.athena.admin.common.validator.group.QiniuGroup;
import com.zhunagxiaoyan.athena.admin.common.validator.group.ValidatorUtils;
import com.zhunagxiaoyan.athena.admin.modules.oss.cloud.CloudStorageConfig;
import com.zhunagxiaoyan.athena.admin.modules.oss.cloud.OSSFactory;
import com.zhunagxiaoyan.athena.admin.modules.oss.entity.SysOssEntity;
import com.zhunagxiaoyan.athena.admin.modules.oss.service.SysOssService;
import com.zhunagxiaoyan.athena.admin.modules.sys.service.SysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 文件上传
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("sys/oss")
public class SysOssController {
    private final static String KEY = ConfigConstant.CLOUD_STORAGE_CONFIG_KEY;
    @Autowired
    private SysOssService sysOssService;
    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:oss:all")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysOssService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 云存储配置信息
     */
    @GetMapping("/config")
    @RequiresPermissions("sys:oss:all")
    public Result config() {
        CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);

        return Result.ok().put("config", config);
    }

    /**
     * 保存云存储配置信息
     */
    @PostMapping("/saveConfig")
    @RequiresPermissions("sys:oss:all")
    public Result saveConfig(@RequestBody CloudStorageConfig config) {
        //校验类型
        ValidatorUtils.validateEntity(config);

        if (config.getType() == Constant.CloudService.QINIU.getValue()) {
            //校验七牛数据
            ValidatorUtils.validateEntity(config, QiniuGroup.class);
        } else if (config.getType() == Constant.CloudService.ALIYUN.getValue()) {
            //校验阿里云数据
            ValidatorUtils.validateEntity(config, AliyunGroup.class);
        } else if (config.getType() == Constant.CloudService.QCLOUD.getValue()) {
            //校验腾讯云数据
            ValidatorUtils.validateEntity(config, QcloudGroup.class);
        }

        sysConfigService.updateValueByKey(KEY, new Gson().toJson(config));

        return Result.ok();
    }

    /**
     * 上传文件
     */
    @PostMapping("/upload")
    @RequiresPermissions("sys:oss:all")
    public Result upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new AthenaException("上传文件不能为空");
        }

        //上传文件
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String url = OSSFactory.build().uploadSuffix(file.getBytes(), suffix);

        //保存文件信息
        SysOssEntity ossEntity = new SysOssEntity();
        ossEntity.setUrl(url);
        ossEntity.setCreateDate(new Date());
        sysOssService.save(ossEntity);

        return Result.ok().put("url", url);
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresPermissions("sys:oss:all")
    public Result delete(@RequestBody Long[] ids) {
        sysOssService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
