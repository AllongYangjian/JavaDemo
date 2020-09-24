package com.allong.example.jdbc.handler;

import java.sql.ResultSet;

public interface ResultSetHandler {
    Object handler(ResultSet resultSet);
}
