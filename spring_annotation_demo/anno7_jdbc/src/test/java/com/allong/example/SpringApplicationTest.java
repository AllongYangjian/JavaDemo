package com.allong.example;

import com.allong.example.config.SpringApplication;
import com.allong.example.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringApplication.class)
public class SpringApplicationTest {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Test
    public void testSave(){
        jdbcTemplate.update("insert into account(name,money) values(?,?)","testA",100);
//        System.err.println(jdbcTemplate.toString());
    }

    @Test
    public void testUpdate(){
        jdbcTemplate.update("update account set name = ?,money= ? where id = ?","testB",150,3);
    }

    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from account where id = ?",4);
    }

    @Test
    public void testFindOne(){
        final Account account = jdbcTemplate.queryForObject("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),2);
        System.err.println(account.toString());

        Account account1 = jdbcTemplate.query("select * from account where id = ?", new ResultSetExtractor<Account>() {
            public Account extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Account account2= null;
                if(resultSet!=null){
                    account2 = new Account();
                    account2.setId(resultSet.getInt("id"));
                    account2.setName(resultSet.getString("name"));
                    account2.setMoney(resultSet.getInt("money"));
                }
                return account2;
            }
        }, 3);
        assert account1!=null;
        System.err.println(account1.toString());
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
        for(Account item:accounts){
            System.err.println(item.toString());
        }
    }

    @Test
    public void testQueryForList(){
        List<Double> doubles = jdbcTemplate.queryForList("select money from account where money > ?",Double.class,20d);
        for(Double item:doubles){
            System.err.println(item.toString());
        }

        List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from account where money >?",99d);
        for(Map<String,Object> map:list){
            for(Map.Entry<String,Object> item:map.entrySet()){
                System.err.println(item.getKey()+","+item.getValue());
            }
        }
    }

    @Test
    public void testFormMap(){
        Map<String,Object> map = jdbcTemplate.queryForMap("select * from account where id = ?",2);
        for(Map.Entry<String,Object> entry:map.entrySet()){
            System.err.println(entry.getKey()+","+entry.getValue());
        }
    }

    @Test
    public void testForRowSet(){
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet("select * from account where money > ?",50);
        while (rowSet.next()){
            System.err.println(rowSet.getString("name"));
        }
    }



}
