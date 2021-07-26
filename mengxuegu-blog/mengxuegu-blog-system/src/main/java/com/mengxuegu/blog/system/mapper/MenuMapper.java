package com.mengxuegu.blog.system.mapper;

import com.mengxuegu.blog.entities.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单信息表 Mapper 接口
 * </p>
 *
 * @author yangjian
 * @since 2021-07-26
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 查询指定用户id所拥有的菜单权限（目录、菜单、按钮）
     * @param userId
     * @return
     */
    List<Menu> findByUserId(@Param("userId") String userId);
}
