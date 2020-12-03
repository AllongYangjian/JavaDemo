package com.example.tkmapper.mapper;

import com.example.tkmapper.domain.Address;
import com.example.tkmapper.domain.EnumStatus;
import com.example.tkmapper.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: UserTest
 * Author:   yangjian
 * Date:     2020/12/3 22:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/12/3 22:42        1.0              描述
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testTypeHandler() {
        List<User> users = userMapper.selectAll();
        users.forEach(item -> System.err.println(item.toString()));
    }

    @Test
    public void testSave() {
        Address address = new Address("中国", "湖北", "潜江");
        User user = new User(null, "--", 28, address, EnumStatus.Autumn);
        int i = userMapper.insertSelective(user);
        System.err.println("insert record count " + i);
    }
}
