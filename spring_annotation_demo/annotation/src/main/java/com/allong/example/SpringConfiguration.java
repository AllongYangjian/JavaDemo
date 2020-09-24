package com.allong.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:jdbc.properties")
@Import(value = JdbcConfig.class)
@ComponentScan
public class SpringConfiguration {

}
