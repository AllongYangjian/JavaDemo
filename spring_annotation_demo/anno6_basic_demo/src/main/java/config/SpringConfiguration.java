package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import support.factory.YamlPropertySourceFactory;

@Configuration
@ComponentScan(value = "com.allong.example")
@Import(JdbcConfig.class)
@PropertySource(value = "classpath:jdbc.yml",factory = YamlPropertySourceFactory.class)
public class SpringConfiguration {

}
