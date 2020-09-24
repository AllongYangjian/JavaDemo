package config;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

class SpringConfigurationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("config");

        String[] str = context.getBeanDefinitionNames();
        for (String s : str) {
            System.err.println(s);
        }


        JdbcTemplate template = context.getBean(JdbcTemplate.class);
        System.err.println(template);
        DataSource dataSource = template.getDataSource();
        System.err.println(dataSource);


    }
}