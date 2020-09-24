package com.allong.example.jdbc.handler.impl;

import com.allong.example.jdbc.handler.ResultSetHandler;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements ResultSetHandler {
    private Class<T> requireType;

    public BeanListHandler(Class requireType) {
        this.requireType = requireType;
    }

    public Object handler(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        try {
            T bean = null;
            while (resultSet.next()){
                bean = requireType.newInstance();
                ResultSetMetaData rsmd = resultSet.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for(int x = 0;x<columnCount;x++){
                    String columnLabel= rsmd.getColumnLabel(x+1);
                    Object value = resultSet.getObject(columnLabel);
                    //java 内省机制，使用属性描述器填充
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnLabel,requireType);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(bean,value);
                }
                list.add(bean);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
