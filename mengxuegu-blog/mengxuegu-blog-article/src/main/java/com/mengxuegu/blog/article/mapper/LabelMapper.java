package com.mengxuegu.blog.article.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mengxuegu.blog.article.req.LabelREQ;
import com.mengxuegu.blog.entities.Label;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 标签表 Mapper 接口
 * </p>
 *
 * @author yangjian
 * @since 2021-07-20
 */
public interface LabelMapper extends BaseMapper<Label> {

    /**
     * 如果自定义的sql要分页查询，只要在mapper写不带分页功能的sql查询语句，mybatis-plus会自动将数据分页，但是必须满足条件
     * 1、第一个参数必须是分页对象Page,第二个参数是查询条件(取一个别名)
     * 最用结果会分装到Page对象中
     * @return
     */
    IPage<Label> queryPage(IPage<Label> page, @Param("req") LabelREQ req);
}
