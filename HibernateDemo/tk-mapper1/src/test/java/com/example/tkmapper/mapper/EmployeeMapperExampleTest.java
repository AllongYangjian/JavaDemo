package com.example.tkmapper.mapper;

import com.example.tkmapper.domain.Employee;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeMapperExampleTest {

    @Autowired
    private EmployeeExampleMapper exampleMapper;


    @Test
    public void testSelectByExample() {
        Example example = new Example(Employee.class);
        /*
         * 其他属性设置
         */
        //设置排序
        example.orderBy("name").asc();
        //设置去重
        example.setDistinct(true);
        //设置查询的列
        example.selectProperties("name", "age");

        Example.Criteria criteria1 = example.createCriteria();
        Example.Criteria criteria2 = example.createCriteria();

        criteria1.andGreaterThan("age", 12);
        criteria2.andLike("email", "%@qq%");
        //example会默认使用第一个创建的Criteria 作为参数，如果需要
        //添加多个查询条件，需要使用Example的and或or方法进行连接
        //SELECT id,name,age,email,last_name FROM employee WHERE ( ( age > ? ) or ( email like ? ) )
        example.or(criteria2);
        List<Employee> e = exampleMapper.selectByExample(example);
        e.forEach(item -> System.err.println(item.toString()));
    }

    @Test
    public void testFakerPage() {
        int pageNo = 3;
        int pageSize = 3;

        int index = (pageNo - 1) * pageSize;
        RowBounds rowBounds = new RowBounds(index, pageSize);
        List<Employee> employees = exampleMapper.selectByRowBounds(null, rowBounds);
        employees.forEach(item -> System.err.println(item.toString()));
    }


}