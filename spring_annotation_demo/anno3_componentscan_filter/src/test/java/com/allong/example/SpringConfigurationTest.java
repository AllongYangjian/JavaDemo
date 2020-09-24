package com.allong.example;


import com.allong.example.service.DistrictPercentage;
import com.allong.example.service.DistrictPerformance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class SpringConfigurationTest {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.allong.example.configuration");

        DistrictPercentage percentage = context.getBean("districtPercentage", DistrictPercentage.class);
        percentage.percentage("car");

        DistrictPerformance performance = context.getBean("districtPerformance", DistrictPerformance.class);
        percentage.percentage("car");
    }
}