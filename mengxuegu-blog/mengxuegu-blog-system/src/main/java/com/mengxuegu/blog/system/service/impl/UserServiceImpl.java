package com.mengxuegu.blog.system.service.impl;

import com.mengxuegu.blog.entities.User;
import com.mengxuegu.blog.system.mapper.UserMapper;
import com.mengxuegu.blog.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
