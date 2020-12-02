package com.example.tkmappergenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.example.tkmappergenerator.mapper")
public class TkMapperGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TkMapperGeneratorApplication.class, args);
    }

}
