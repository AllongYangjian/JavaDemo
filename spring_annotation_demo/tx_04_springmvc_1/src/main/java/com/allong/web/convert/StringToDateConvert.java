package com.allong.web.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器
 * 1、添加类实现Converter
 * 2、将类注入到ioc容器
 * 3、在控制器方法执行之前添加自定义转换器
 * @ControllerAdvice @InitBinder
 */
@Component
public class StringToDateConvert implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if(StringUtils.isEmpty(source)){
            throw new NullPointerException("Source can not be null");
        }
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(source);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
