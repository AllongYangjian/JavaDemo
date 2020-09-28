package com.example.mapstrcut.utils;

import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: BooleanStrFormat
 * Author:   YJ
 * Date:     2020/9/28 13:57
 * Description: 字符串和String的转换
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/28 13:57        1.0              描述
 */
@Component
public class BooleanStrFormat {
    public String toStr(Boolean b){
        if(b){
            return "Y";
        }else {
            return "N";
        }
    }

    public Boolean toBoolean(String str){
        if(str.equals("Y")){
            return true;
        }else {
            return false;
        }
    }
}
