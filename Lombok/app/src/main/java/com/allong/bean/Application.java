package com.allong.bean;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Application
 * Author:   YJ
 * Date:     2020/9/25 13:33
 * Description: 启动类
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/25 13:33        1.0              描述
 */
@Log4j2
public class Application {

    public static void main(String[] args) {
        Student student = new Student();
        AccountInfo accountInfo = new AccountInfo();
        log.info(student.toString());
        log.info(accountInfo.toString());
        Demo demo = new Demo.DemoBuilder().id(1)
                .name("sb")
                .build();
        log.info(demo.toString());

//        try {
            testIo2();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    private static void testIo() {
        File file = new File("a.txt");
        try {
            @Cleanup FileOutputStream fos = new FileOutputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows(Exception.class)
    public static void testIo2() {
        System.err.println(5/0);
    }
}
