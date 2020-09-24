package com.allong.example.transaction.event;

import org.springframework.context.ApplicationEvent;

/**
 * 注册事件监听器
 */
public class MyApplicationEvent extends ApplicationEvent {

    public MyApplicationEvent(Object source) {
        super(source);
    }


}
