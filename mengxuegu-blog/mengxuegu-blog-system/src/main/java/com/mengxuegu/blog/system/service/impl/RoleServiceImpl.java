package com.mengxuegu.blog.system.service.impl;

import com.mengxuegu.blog.entities.Role;
import com.mengxuegu.blog.system.mapper.RoleMapper;
import com.mengxuegu.blog.system.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-26
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
