package com.allong.springdata;

import com.allong.springdata.domain.Dept;
import com.allong.springdata.service.DeptService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.security.RunAs;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class SpringDataApplicationTests {

    @Autowired
    private DeptService deptService;

    @Test
    void contextLoads() {
        List<Dept> dept = deptService.queryAll();
        System.err.println(dept.toString());
    }

}
