package com.allong.example;

import com.allong.example.config.SpringApplication;
import com.allong.example.domain.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.FileCopyUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringApplication.class)
public class SpringLogTest {
    @Autowired
    private JdbcTemplate template;

    @Autowired
    private LobHandler lobHandler;

    @Test
    public void testWrite() {
        try {
            Resource resource = new FileSystemResource("C:\\Users\\YJ\\Desktop\\图片资源\\image 120\\WechatIMG109.png");
            byte[] images = FileCopyUtils.copyToByteArray(resource.getFile());
            String description = ".";
            final UserInfo userInfo = new UserInfo();
            userInfo.setImages(images);
            userInfo.setDescription(description);

            template.execute("insert into userinfo (images,description) values(?,?)", new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
                @Override
                protected void setValues(PreparedStatement preparedStatement, LobCreator lobCreator) throws SQLException, DataAccessException {
                    lobCreator.setBlobAsBytes(preparedStatement, 1, userInfo.getImages());
                    lobCreator.setClobAsString(preparedStatement, 2, userInfo.getDescription());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRead() {
        final UserInfo userInfo = template.queryForObject("select * from userinfo where id = ?",new BeanPropertyRowMapper<UserInfo>(UserInfo.class),1);
        System.err.println(userInfo.toString());

        UserInfo userInfo1 = template.query("select * from userinfo where id = ?", new ResultSetExtractor<UserInfo>() {
            public UserInfo extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                UserInfo userInfo2 = null;
                if(resultSet.next()){
                    userInfo2 = new UserInfo();
                    userInfo2.setId(resultSet.getInt("id"));
                    userInfo2.setImages(lobHandler.getBlobAsBytes(resultSet,"images"));
                    userInfo2.setDescription(lobHandler.getClobAsString(resultSet,"description"));
                }
                return userInfo2;
            }
        }, 2);
        System.err.println(userInfo1.toString());
    }
}
