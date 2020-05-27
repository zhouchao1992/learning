package com.zc.mybatisplustest.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zc.common.result.Result;
import com.zc.mybatisplustest.entity.UmsAdmin;
import com.zc.mybatisplustest.service.IUmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author zc
 * @since 2020-05-20
 */
@RestController
@RequestMapping("/mybatisplustest/ums-admin")
//@Api(tags="用户信息查询")
public class UmsAdminController {
    @Resource
    IUmsAdminService service;

    @GetMapping("/umsAdminList")
    @ApiOperation("查询用户列表")
    public Result umsAdminList(UmsAdmin umsAdmin){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",umsAdmin.getId());
        List<UmsAdmin> list = service.list(wrapper);
        return  Result.ofSuccess(list);
    }


    @GetMapping("/selectUmsAdminList")
    @ApiOperation("用户列表分页查询")
    public IPage<UmsAdmin> selectUmsAdminList(Integer size,Integer current){
        Page<UmsAdmin> page = new Page<>();
        page.setSize(size);
        page.setCurrent(current);
        return  service.selectUmsAdminList(page);
    }

    @PutMapping("/umsAdminUpdate")
    @ApiOperation("修改用户信息")
    public Result umsAdminUpdate(UmsAdmin umsAdmin){
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.set("username",umsAdmin.getUsername());
        wrapper.eq("id",umsAdmin.getId());
        boolean update = service.update(wrapper);
        return  Result.ofSuccess(update);
    }
}
