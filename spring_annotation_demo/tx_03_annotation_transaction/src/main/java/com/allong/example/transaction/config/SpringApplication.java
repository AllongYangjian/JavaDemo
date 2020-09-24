package com.allong.example.transaction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({TransactionManagerConfig.class,JdbcConfig.class})
@ComponentScan(value = "com.allong.example.transaction")
@PropertySource(value = "classpath:jdbc.properties")
@EnableTransactionManagement //开启spring事务注解支持
public class SpringApplication {

    /*
     * Spring开启事务的步骤
     * 1、配置事务管理器 PlatformTransactionManager
     * 2、使用@EnableTransactionManagement开启事务注解支持
     * 3、在对应的方法上使用@Transactional 标明该方法开启事务
     */

    /*
     * spring 事务监听器的使用
     * 1、自定义监听事件继承ApplicationEvent
     * 2、创建事件监听器，注入到spring容器中，使用 @TransactionalEventListener 标明监听的事件
     * 3、使用spring容器提供的 ApplicationEventPublisher 发布事件监听
     */
}
