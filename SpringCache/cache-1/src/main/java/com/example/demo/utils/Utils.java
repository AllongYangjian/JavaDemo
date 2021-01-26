package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: Utils
 * Author:   yangjian
 * Date:     2021/1/26 21:41
 * Description: 工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/1/26 21:41        1.0              描述
 */
public class Utils {

    public static String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
