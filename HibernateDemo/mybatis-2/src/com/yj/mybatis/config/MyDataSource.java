package com.yj.mybatis.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.io.Resources;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: MyDataSource
 * Author:   yangjian
 * Date:     2020/11/17 22:38
 * Description: 自定义C3P0数据源
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/17 22:38        1.0              描述
 */
public class MyDataSource implements DataSourceFactory {
    @Override
    public void setProperties(Properties properties) {
        try {
            properties.load(Resources.getResourceAsStream("c3p0.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DataSource getDataSource() {
        return new ComboPooledDataSource("c3p0.properties");
    }
}
