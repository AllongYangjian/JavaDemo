package com.example.tkmapper.mapper;

import com.example.tkmapper.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper mapper;


    @Test
    public void testSave() {
        Employee employee = new Employee(95, "lwh", 222, "lwh@qq.com", "ss");
        boolean exists = mapper.existsWithPrimaryKey(employee.getId());
        int result;
        if (exists) {
            result = mapper.updateByPrimaryKey(employee);
        } else {
            employee.setId(null);
            result = mapper.insert(employee);
        }
        System.err.println("insert result:" + result);
    }

    /**
     * 封装查询条件查询
     * 1、使用非空值进行查询
     * 2、默认使用等号
     * 3、当查询返回多个结果时，会报异常
     * Expected one result (or null) to be returned by selectOne(), but found: 2
     */
    @Test
    public void testSelectOne() {
        Employee employee = new Employee();
//        employee.setId(1);
//        employee.setAge(14);
        employee.setLastName("y");
        Employee employee1 = mapper.selectOne(employee);
        System.err.println(employee);
        System.err.println(employee1);
    }

    /**
     * 根据主键查询时需要指定主键为哪一列
     * 通过在实体类中指定主键才能进行查询
     * <p>
     *
     * @Id
     * @GeneratedValue(strategy = GenerationType.IDENTITY)
     * private Integer id;
     * </p>
     * 否则会将所有字段整合在一起，作为联合主键查询
     * <code> SELECT id,name,age,email,last_name FROM employee WHERE id = ? AND name = ? AND age = ? AND email = ? AND last_name = ?</code>
     */
    @Test
    public void testSelectByPrimaryKey() {
        Employee employee = mapper.selectByPrimaryKey(1);
        System.err.println(employee.toString());
    }

    @Test
    public void testSelect() {
        List<Employee> employees = mapper.selectAll();
        System.err.println(employees.toString());
    }

    /**
     * 值为null的字段不会出现在sql语句中，但是主键除外
     */
    @Test
    public void testInsertSelective() {
        Employee employee = new Employee(null, "lwh", 222, "lwh@qq.com", null);
        mapper.insertSelective(employee);
        System.err.println(employee.getId());
    }

    @Test
    public void testUpdateByPrimaryKeySelective(){
        Employee employee = new Employee(2, "test", 12, "test@qq.com", null);
        int index = mapper.updateByPrimaryKeySelective(employee);
        System.err.println("update record count "+index);
    }

    /**
     * 注意，如果传入的实体类对象的字段都是空，则会清空表
     */
    @Test
    public void testDelete(){
        Employee employee = new Employee();
        mapper.delete(employee);
    }

    @Test
    public void deleteByPrimaryKey(){
//        Employee employee = new Employee();
        mapper.deleteByPrimaryKey(3);
    }




}