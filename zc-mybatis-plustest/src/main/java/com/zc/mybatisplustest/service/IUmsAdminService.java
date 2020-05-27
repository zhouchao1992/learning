package com.zc.mybatisplustest.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zc.mybatisplustest.entity.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author zc
 * @since 2020-05-20
 */
public interface IUmsAdminService extends IService<UmsAdmin> {
    //分页查询
    IPage<UmsAdmin> selectUmsAdminList(Page<UmsAdmin> page);
}
