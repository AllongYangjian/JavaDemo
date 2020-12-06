package com.example.mybatisplus1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
//        List<Employee> empList = employeeMapper.getEmpList();
//        empList.forEach(item -> System.err.println(item.toString()));
//        Employee employee = new Employee();
//        employee.setId(1);
//        Employee employee1 = employeeMapper.selectOne(employee);
        List<Employee> age = employeeMapper.selectList(new QueryWrapper<Employee>().gt("age", 12));
        age.forEach(item -> System.err.println(item.toString()));
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
    void testUpdate() {
        Employee employee = new Employee();
        employee.setAge(122);
        employee.setLastName("---s");
//        employee.setEmail("uy");
//        employee.setLastName("jy");

//        int result = employeeMapper.updateById(employee);
//        System.err.println("update record count "+result);
//        Wrapper<Employee> wrapper = new UpdateWrapper<>(employee);

        //UPDATE employee SET last_name=?, age=? WHERE (id = ?)
        int result = employeeMapper.update(employee, new UpdateWrapper<Employee>().eq("id", 2));
        System.err.println("update record count " + result);

    }

    @Test
    void testSelect() {
//        e.setAge(29);
        List<Employee> employees = employeeMapper.selectList(null);
        employees.forEach(item -> System.err.println(item.toString()));
    }

    @Test
    public void testByPage() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<Employee>()
                .gt("age", 10);
        Page<Employee> employeePage1 = new Page<>(2, 3);
        employeeMapper.selectPage(employeePage1, wrapper);
        List<Employee> records = employeePage1.getRecords();
        records.forEach(item -> System.err.println(item.toString()));
    }

    @Test
    void testByPage2() {
        IPage<Employee> employeePage1 = new Page<>(2, 3);
        //测试，不添加分页插件 的情况下 ，分页无效
        employeePage1 = employeeMapper.selectPage(employeePage1, null);
        List<Employee> records = employeePage1.getRecords();
        records.forEach(item -> System.err.println(item.toString()));

    }

}
