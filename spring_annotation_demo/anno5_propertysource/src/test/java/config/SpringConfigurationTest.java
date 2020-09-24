package config;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class SpringConfigurationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("config");

        DriverManagerDataSource dataSource = context.getBean("dataSource", DriverManagerDataSource.class);
        System.err.println(dataSource.getUsername());
    }
}