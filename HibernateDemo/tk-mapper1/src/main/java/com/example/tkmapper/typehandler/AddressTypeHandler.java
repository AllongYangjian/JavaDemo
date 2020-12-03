package com.example.tkmapper.typehandler;

import com.example.tkmapper.domain.Address;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: AddressTypeHandler
 * Author:   yangjian
 * Date:     2020/12/3 22:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/12/3 22:35        1.0              描述
 */
public class AddressTypeHandler extends BaseTypeHandler<Address> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Address address, JdbcType jdbcType) throws SQLException {
        if (address == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(address.getNational())
                .append(",")
                .append(address.getProvince())
                .append(",")
                .append(address.getCity());
        ps.setString(i, sb.toString());
    }

    @Override
    public Address getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String text = rs.getString(columnName);
        if (text == null || text.length() == 0 || !text.contains(",")) {
            return null;
        }
        String[] params = text.split(",");
        return new Address(params[0], params[1], params[2]);
    }

    @Override
    public Address getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String text = rs.getString(columnIndex);
        if (text == null || text.length() == 0 || !text.contains(",")) {
            return null;
        }
        String[] params = text.split(",");
        return new Address(params[0], params[1], params[2]);
    }

    @Override
    public Address getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String text = cs.getString(columnIndex);
        if (text == null || text.length() == 0 || !text.contains(",")) {
            return null;
        }
        String[] params = text.split(",");
        return new Address(params[0], params[1], params[2]);
    }
}
