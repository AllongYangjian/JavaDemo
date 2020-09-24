package com.allong.example.service.impl;

import com.allong.example.annotations.District;
import com.allong.example.service.DistrictPercentage;
import org.springframework.stereotype.Service;

@Service("districtPercentage")
@District("north")
public class NorthDistrictPercentage implements DistrictPercentage {

    public void percentage(String type) {
        if (type.equals("car")) {
            System.err.println("华北区SUV分成方式:0.5%");
        } else if (type.equals("suv")) {
            System.err.println("华北区SUV分成方式:1%");
        } else {
            System.err.println("华北区分成方式未定");
        }
    }
}
