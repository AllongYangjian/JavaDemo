package com.allong.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: WebSocketConfig
 * Author:   YJ
 * Date:     2020/4/16 21:19
 * Description: WebSocket配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/4/16 21:19        1.0              描述
 */
@EnableWebSocket
@Configuration
public class WebSocketConfig implements WebSocketConfigurer {


    @Autowired
    private WebSocketHandler webSocketHandler;

    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(webSocketHandler,"/websocket");
    }

    @Bean
    public WebSocketHandler webSocketHandler(){
        return new WebSocketHandler();
    }
}
