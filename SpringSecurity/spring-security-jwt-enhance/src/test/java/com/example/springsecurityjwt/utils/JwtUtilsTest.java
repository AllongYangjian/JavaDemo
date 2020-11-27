package com.example.springsecurityjwt.utils;


import com.example.springsecurityjwt.domain.SysUser;
import com.example.springsecurityjwt.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JwtUtilsTest {

    @Autowired
    private UserService service;

    @Test
    public void testJwt() {
        SysUser user = (SysUser) service.loadUserByUsername("admin");
        user.setPassword(null);
        String token = JwtUtils.generatorToken(user);
        System.err.println("加密成功：" + token);
        SysUser user1 = JwtUtils.decodeToken(token);
        System.err.println("解密成功:" + user1.toString());
    }


}