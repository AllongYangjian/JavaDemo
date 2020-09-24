package com.allong.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import(JdbcConfig.class)
@ComponentScan(value = "com.allong.example")
@PropertySource(value = "classpath:jdbc.properties")
public class SpringApplication {

}
