package com.allong.example;

import com.allong.example.config.SpringApplication;
import com.allong.example.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringApplication.class)
public class NamedParameterJdbcTemplateTest {

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Test
    public void testFind(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",2);
        Account account = template.queryForObject("select * from account where id = :id",map,new BeanPropertyRowMapper<Account>(Account.class));

        System.err.println(account.toString());
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("jy");
        account.setMoney(1234);

        BeanMap map =BeanMap.create(account);
        template.update("insert into account(name,money) values(:name,:money)",map);
    }
}
