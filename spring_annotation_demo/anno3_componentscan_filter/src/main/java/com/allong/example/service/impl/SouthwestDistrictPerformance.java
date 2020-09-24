package com.allong.example.service.impl;

import com.allong.example.annotations.District;
import com.allong.example.service.DistrictPerformance;
import org.springframework.stereotype.Service;

@Service("districtPerformance")
@District("southwest")
public class SouthwestDistrictPerformance implements DistrictPerformance {

    public void performance(String type) {
        if (type.equals("car")) {
            System.err.println("西南区汽车绩效：50");
        } else if (type.equals("suv")) {
            System.err.println("西南区SUV绩效：80");
        } else {
            System.err.println("西南区绩效未知");
        }
    }
}
