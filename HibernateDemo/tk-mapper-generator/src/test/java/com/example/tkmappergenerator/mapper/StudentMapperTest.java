package com.example.tkmappergenerator.mapper;

import com.example.tkmappergenerator.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentMapperTest {

    @Autowired
    private EmployeeMapper mapper;

    @Test
    public void testSelect() {
        List<Employee> employees = mapper.selectAll();
        employees.forEach(item -> System.err.println(item.toString()));
    }

}