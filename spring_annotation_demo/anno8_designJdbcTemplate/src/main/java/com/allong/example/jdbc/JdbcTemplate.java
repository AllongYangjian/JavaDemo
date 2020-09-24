package com.allong.example.jdbc;

import com.allong.example.jdbc.handler.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.*;

public class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JdbcTemplate() {
    }

    public Object query(String sql, ResultSetHandler handler, Object... params) {

        if (dataSource == null) {
            throw new IllegalStateException("Datasource can not be null");
        }
        int res = 0;
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            pstm = connection.prepareStatement(sql);
            ParameterMetaData data = pstm.getParameterMetaData();

            int paramCount = data.getParameterCount();

            if (paramCount > 0) {
                if (params == null) {
                    throw new IllegalStateException("params can not be null");
                }

                if (paramCount != params.length) {
                    throw new IllegalStateException("Incorrect parameter size:expected " + paramCount + " actual " + params.length);
                }
                for (int x = 0; x < paramCount; x++) {
                    pstm.setObject(x +1, params[x]);
                }
            }
            resultSet = pstm.executeQuery();
            return handler.handler(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(resultSet, pstm, connection);
        }
        return res;
    }

    private void release(ResultSet resultSet, PreparedStatement pstm, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
