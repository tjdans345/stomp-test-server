package com.example.stomptestserver.config.stomp;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class StompWebSocketConfig implements WebSocketMessageBrokerConfigurer { // 웹 소켓 사용 ( STOMP 프로토콜을 사용하겠다.

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // queue : 1:1 , topic : 1:N
//        registry.setApplicationDestinationPrefixes("/pub")
//                .enableSimpleBroker("/queue","/topic"); // 이게 메모리 브로커인듯 . .
//        registry.setPathMatcher(new AntPathMatcher(".")) // url 을 chat/room/3 -> chat.room.3으로 참조하기 위한 설정
        registry.setApplicationDestinationPrefixes("/pub")
                .enableStompBrokerRelay("/queue", "/topic", "/exchange", "/amq/queue")
//                .enableStompBrokerRelay("/topic")
                .setRelayHost("localhost")
                .setVirtualHost("/")
                .setRelayPort(5672)
                .setClientLogin("username")
                .setClientPasscode("password");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint("/ws")
                .setAllowedOrigins("*");
//                .withSockJS();
    }



}

