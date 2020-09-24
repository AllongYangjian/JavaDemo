package com.allong.example;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringConfigurationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.allong.example");
        JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
        template.update("insert into account(name,money) values (?,?)","test1",123);
    }
}