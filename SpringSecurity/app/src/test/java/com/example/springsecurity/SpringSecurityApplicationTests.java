package com.example.springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringSecurityApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testPwd(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.err.println(encoder.encode("123"));
    }

}
