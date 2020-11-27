package com.allong.mybatis4.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.io.Resources;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: CustomDatasource
 * Author:   yangjian
 * Date:     2020/11/21 22:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/21 22:52        1.0              描述
 */
public class CustomDatasource implements DataSourceFactory {
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
