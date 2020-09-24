package com.allong.example.jdbc.handler.impl;

import com.allong.example.jdbc.handler.ResultSetHandler;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class BeanHandler<T> implements ResultSetHandler {

    private Class<T> requireType;

    public BeanHandler(Class requireType) {
        this.requireType = requireType;
    }

    public Object handler(ResultSet resultSet) {
        T bean = null;
        try {
            if(resultSet.next()){
                bean = requireType.newInstance();
                ResultSetMetaData rsmd = resultSet.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for(int x = 0;x<columnCount;x++){
                    String columnLabel= rsmd.getColumnLabel(x+1);
                    Object value = resultSet.getObject(columnLabel);
                    System.err.println(columnLabel+","+value);
                    //java 内省机制，使用属性描述器填充
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnLabel,requireType);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(bean,value);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }
}
