package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import(JdbcConfig.class)
@PropertySource(value = "classpath:jdbc.properties")
public class SpringConfiguration {
}
