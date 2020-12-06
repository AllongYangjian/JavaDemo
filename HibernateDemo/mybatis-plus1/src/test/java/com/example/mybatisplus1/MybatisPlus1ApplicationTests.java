package com.example.mybatisplus1;

import com.example.mybatisplus1.domain.Employee;
import com.example.mybatisplus1.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlus1ApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void contextLoads() {
        List<Employee> empList = employeeMapper.getEmpList();
        System.err.println(empList);
    }

    @Test
    void testSave() {
        for (int x = 0; x < 10; x++) {
            String lastName = "yangjian#" + x;
            Employee employee = new Employee();
            employee.setId(null);
            employee.setLastName(lastName);
            employee.setAge(28 + x);
            employee.setGender(1);
            employee.setEmail(lastName + "@qq.com");
            employeeMapper.insert(employee);
        }
    }

    @Test
    void testSelect() {
        List<Employee> employees = employeeMapper.selectList(null);
        System.err.println(employees.toString());
    }

}
