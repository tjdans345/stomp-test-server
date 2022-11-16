package com.example.stomptestserver.config.stomp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class StompWebSocketConfig implements WebSocketMessageBrokerConfigurer { // 웹 소켓 사용 ( STOMP 프로토콜을 사용하겠다.

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint("/stomp/chat") // handshake 와 통신을 담당할 endpoint 를 지정
                .setAllowedOriginPatterns("*");
//                .withSockJS();
    }

    // stomp 프로토콜 설정
    // 소켓 연결 담당
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // send 요청 처리
//        registry.setApplicationDestinationPrefixes("/pub");
        // enableStompBrokerRelay : SimpleBroker 의 기능과 외부 message broker(RabbitMQ, ActiveMQ 등)에 메시지를 전달하는 기능을 가지고 있음.
        // 외부 메세지 브로커인 RabbitMQ 연결 설정
//        registry.enableStompBrokerRelay("/queue", "/topic", "/exchange", "/amq/queue"); // queue : 1:1 , topic : 1:N
//                .setRelayHost("localhost")
//                // docker 로 돌릴 때 도커 컨테이너 포트 61613 맞춰 줘야함
//                // rabbitMQ stomp 설정해줘야함 명령어 : rabbitmq-plugins enable rabbitmq_web_stomp
//                .setRelayPort(61613) // 메시지 브로커 포트 설정
//                .setSystemLogin(username)
//                .setSystemPasscode(password)
//                .setClientLogin(username)
//                .setClientPasscode(password);
//    }


    // 아래 코드 참조 블로그 : https://velog.io/@yyong3519/WebSocket-RabbitMQ
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        registry.setPathMatcher(new AntPathMatcher(".")); // url 을 chat/room/3 -> chat.room.3 으로 참조하기 위한 설정
        // send 요청 처리
        registry.setApplicationDestinationPrefixes("/pub");
        // enableStompBrokerRelay : SimpleBroker 의 기능과 외부 message broker(RabbitMQ, ActiveMQ 등)에 메시지를 전달하는 기능을 가지고 있음.
        // 외부 메세지 브로커인 RabbitMQ 연결 설정
        registry.enableStompBrokerRelay("/queue", "/topic", "/exchange", "/amq/queue"); // queue : 1:1 , topic : 1:N
    }






}

