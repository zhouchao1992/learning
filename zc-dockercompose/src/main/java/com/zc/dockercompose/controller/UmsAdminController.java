package com.zc.dockercompose.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zc.dockercompose.entity.UmsAdmin;
import com.zc.dockercompose.service.IUmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author zc
 * @since 2020-06-16
 */
@RestController
@Api(tags = "后台用户信息")
@RequestMapping("/admin/ums-admin/")
public class UmsAdminController {

    @Resource
    IUmsAdminService service;

    @GetMapping("list")
    @ApiOperation(value = "根据分页条件获取用户信息")
    public IPage<UmsAdmin> listUmsAdmin( Integer size,Integer current){
        if (size==0)size=10;
        if (current==0)current=1;
        Page<UmsAdmin> page = new Page<>();
        page.setSize(size);
        page.setCurrent(current);
        return service.selectUmsAdminList(page);
    }

}
