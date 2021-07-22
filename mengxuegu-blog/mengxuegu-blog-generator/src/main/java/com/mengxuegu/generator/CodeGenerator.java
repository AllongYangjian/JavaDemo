package com.mengxuegu.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: CodeGenerator
 * Author:   yangjian
 * Date:     2021/7/20 22:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/20 22:13        1.0              描述
 */
public class CodeGenerator {
    public static String PROJECT_NAME = "mengxuegu-blog-article";

    public static String DATABASE_NAME = "mxg_blog_article";

    private static String MODULE_NAME = "article";

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();

        DataSourceConfig config = new DataSourceConfig();
        config.setUrl("jdbc:mysql://127.0.0.1:3306/" + DATABASE_NAME + "?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&allowMultiQueries=true");
        config.setUsername("root");
        config.setPassword("allong");
        config.setDriverName("com.mysql.cj.jdbc.Driver");

        generator.setDataSource(config);

        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir") + "/";
        globalConfig.setOutputDir(projectPath + PROJECT_NAME + "/src/main/java");
        globalConfig.setIdType(IdType.ASSIGN_ID);
        globalConfig.setAuthor("yangjian");
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(false);
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setSwagger2(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setBaseResultMap(true);
        generator.setGlobalConfig(globalConfig);

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.mengxuegu.blog");
        packageConfig.setController(MODULE_NAME + ".controller");
        packageConfig.setService(MODULE_NAME + ".service");
        packageConfig.setServiceImpl(MODULE_NAME + ".service.impl");
        packageConfig.setMapper(MODULE_NAME + ".mapper");
        packageConfig.setXml(MODULE_NAME + ".mapper.xml");
        packageConfig.setEntity("entities");

        generator.setPackageInfo(packageConfig);

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setEntitySerialVersionUID(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
        strategyConfig.setTablePrefix("mxg_");
//        strategyConfig.setExclude("mxg_category");
        strategyConfig.setInclude("mxg_comment");

        generator.setStrategy(strategyConfig);

        generator.setTemplateEngine(new FreemarkerTemplateEngine());

        generator.execute();
    }

}
