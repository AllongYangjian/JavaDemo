package com.example.mybatisplusgenerator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: CodeGenerator
 * Author:   yangjian
 * Date:     2020/12/6 21:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/12/6 21:42        1.0              描述
 */
public class CodeGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setActiveRecord(true)
                .setOutputDir("E:\\SourceCode\\JavaDemo\\HibernateDemo\\mybatis-plus-generator\\src\\main\\java")
                .setFileOverride(true)
                .setAuthor("杨建")
                .setIdType(IdType.AUTO)
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setBaseResultMap(true)
                .setBaseColumnList(true);
        //数据源配置
        DataSourceConfig config = new DataSourceConfig();
        config.setUrl("jdbc:mysql:///mybatis_plus?serverTimezone=UTC")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("allong");
        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude("employee");

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.example.mybatisplusgenerator")
                .setController("controller")
                .setEntity("domain")
                .setMapper("mapper")
                .setService("service")
                .setServiceImpl("service.impl")
                .setXml("mapper");

        mpg.setGlobalConfig(gc)
                .setDataSource(config)
                .setPackageInfo(packageConfig)
                .setStrategy(strategyConfig);

        mpg.execute();

    }

}
