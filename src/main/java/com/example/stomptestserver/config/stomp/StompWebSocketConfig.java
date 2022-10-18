package com.example.stomptestserver.config.stomp;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class StompWebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // queue : 1:1 , topic : 1:N
//        registry.enableSimpleBroker("/queue","/topic");
        registry.setPathMatcher(new AntPathMatcher(".")) // url 을 chat/room/3 -> chat.room.3으로 참조하기 위한 설정
                .setApplicationDestinationPrefixes("/pub")
                .enableStompBrokerRelay("/queue", "/topic", "exchange");
//                .setRelayHost("localhost")
//                .setVirtualHost("/")
//                .setRelayPort(61613)
//                .setClientLogin("guest")
//                .setClientPasscode("guest");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint("/stomp/chat")
                .addInterceptors()
                .setAllowedOrigins("*");
//                .withSockJS();
    }



}

