package com.zc.mybatisplustest.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zc.mybatisplustest.entity.UmsAdmin;
import com.zc.mybatisplustest.mapper.UmsAdminMapper;
import com.zc.mybatisplustest.service.IUmsAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author zc
 * @since 2020-05-20
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements IUmsAdminService {

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @Override
    public IPage<UmsAdmin> selectUmsAdminList(Page<UmsAdmin> page) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return umsAdminMapper.selectUmsAdminList(page);
    }
}
