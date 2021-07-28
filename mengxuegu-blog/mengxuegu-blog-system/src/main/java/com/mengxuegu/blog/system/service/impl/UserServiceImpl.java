package com.mengxuegu.blog.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mengxuegu.blog.entities.User;
import com.mengxuegu.blog.feign.IFeignArticleController;
import com.mengxuegu.blog.feign.IFeignQuestionController;
import com.mengxuegu.blog.feign.req.UserInfoREQ;
import com.mengxuegu.blog.system.mapper.UserMapper;
import com.mengxuegu.blog.system.req.SysUserCheckPasswordREQ;
import com.mengxuegu.blog.system.req.SysUserREQ;
import com.mengxuegu.blog.system.req.SysUserUpdatePasswordREQ;
import com.mengxuegu.blog.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mengxuegu.blog.util.base.Result;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Transactional // 事务管理
    @Override
    public Result saveUserRole(String userId, List<String> roleIds) {
        // 1. 删除用户角色关系表数据
        baseMapper.deleteUserRoleByUserId(userId);
        // 2. 保存新的用户角色关系表数据
        if(CollectionUtils.isNotEmpty(roleIds)) {
            baseMapper.saveUserRole(userId, roleIds);
        }
        return Result.ok();
    }

    @Override
    public Result deleteById(String id) {
        // 1. 先查询当前用户是否存在，
        User sysUser = baseMapper.selectById(id);
        if(sysUser == null) {
            return Result.error("用户不存在，删除失败");
        }
        // 2. 如果存在再进行删除
        sysUser.setIsEnabled(0); // 0 删除，1可用
        sysUser.setUpdateDate(new Date());
        baseMapper.updateById(sysUser);
        return Result.ok();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Result checkPassword(SysUserCheckPasswordREQ req) {
        if(StringUtils.isEmpty(req.getUserId())) {
            return Result.error("用户ID不能为空，请重试");
        }

        if(StringUtils.isEmpty(req.getOldPassword())) {
            return Result.error("原密码不能为空，请重试");
        }

        User sysUser = baseMapper.selectById(req.getUserId());
        if(sysUser == null) {
            return Result.error("用户不存在，请重试");
        }
        // matches 方法中参数1：用户输入的密码（明文），参数2: 是数据库中密码（密文）
        boolean isOk = passwordEncoder.matches( req.getOldPassword(), sysUser.getPassword() );
        if( !isOk ) {
            return Result.error("原密码输入错误");
        }

        return Result.ok();
    }

    @Override
    public Result updatePassword(SysUserUpdatePasswordREQ req) {
        if(StringUtils.isEmpty(req.getUserId())) {
            return Result.error("用户ID不能为空，请重试");
        }
        if(StringUtils.isEmpty(req.getNewPassword())) {
            return Result.error("新密码不能为空，请重试");
        }
        if(StringUtils.isEmpty(req.getRepPassword())) {
            return Result.error("确认密码不能为空，请重试");
        }
        if( !req.getNewPassword().equals( req.getRepPassword() )) {
            return Result.error("新密码与确认密码不一致，请重试");
        }

        User sysUser = baseMapper.selectById(req.getUserId());
        if(sysUser == null) {
            return Result.error("用户不存在，请重试");
        }

        // 如果有原密码，则校验是否正确
        if(StringUtils.isNotEmpty(req.getOldPassword())) {
            if( !passwordEncoder.matches( req.getOldPassword(), sysUser.getPassword() ) ) {
                return Result.error("原密码输入错误");
            }
        }

        // 校验都通过，将新密码进行加密存储
        sysUser.setPassword( passwordEncoder.encode(req.getNewPassword()) );
        sysUser.setPwdUpdateDate(new Date());
        baseMapper.updateById(sysUser);

        return Result.ok();
    }

    @Autowired
    private IFeignArticleController feignArticleController;

    @Autowired
    private IFeignQuestionController feignQuestionController;

    @Transactional
    @Override
    public Result update(User sysUser) {
        // 1. 查询原用户信息
        User user = baseMapper.selectById(sysUser.getId());
        // 2. 判断更新的用户信息中昵称和头像是否被改变
        if( !StringUtils.equals(sysUser.getNickName(), user.getNickName())
                || !StringUtils.equals(sysUser.getImageUrl(), user.getImageUrl())
        ) {
            //   2.1 只要其中一个被改变，则调用文章和问答微服务更新用户信息
            // 更新文章微服务中的用户信息
            UserInfoREQ userInfoREQ =
                    new UserInfoREQ(sysUser.getId(), sysUser.getNickName(), sysUser.getImageUrl());
            feignArticleController.updateUserInfo(userInfoREQ);
            // 更新问答微服务用户信息
            feignQuestionController.updateUserInfo(userInfoREQ);
        }

        // 3. 更新用户信息表数据 sys_user
        sysUser.setUpdateDate(new Date());
        baseMapper.updateById(sysUser);
        // 4. 响应更新成功
        return Result.ok();
    }

    @Override
    public Result getUserTotal() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 帐户是否可用(1 可用，0 删除用户)
        wrapper.eq("is_enabled", 1);
        Integer total = baseMapper.selectCount(wrapper);
        return Result.ok(total);
    }


}
