package com.mengxuegu.blog.system.service.impl;

import com.mengxuegu.blog.entities.Menu;
import com.mengxuegu.blog.system.mapper.MenuMapper;
import com.mengxuegu.blog.system.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单信息表 服务实现类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-26
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
