package com.mengxuegu.blog.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mengxuegu.blog.entities.User;
import com.mengxuegu.blog.system.mapper.UserMapper;
import com.mengxuegu.blog.system.req.SysUserREQ;
import com.mengxuegu.blog.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mengxuegu.blog.util.base.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public Result queryPage(SysUserREQ req) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        if(StringUtils.isNotEmpty(req.getUsername())) {
            wrapper.like("username", req.getUsername());
        }

        if(StringUtils.isNotEmpty(req.getMobile())) {
            wrapper.like("mobile", req.getMobile());
        }

        wrapper.orderByDesc("update_date");

        return Result.ok( baseMapper.selectPage(req.getPage(), wrapper) );
    }

    @Override
    public Result findRoleIdsById(String id) {
        List<String> roleIds = baseMapper.findRoleIdsById(id);
        return Result.ok(roleIds);
    }

}
