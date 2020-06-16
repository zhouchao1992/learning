package com.zc.dockercompose.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zc.dockercompose.entity.UmsAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author zc
 * @since 2020-06-16
 */
public interface UmsAdminMapper extends BaseMapper<UmsAdmin> {
    //分页查询
    IPage<UmsAdmin> selectUmsAdminList(Page page);
}
