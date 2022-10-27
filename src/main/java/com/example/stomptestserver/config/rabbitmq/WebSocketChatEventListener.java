package com.example.stomptestserver.config.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WebSocketChatEventListener {

    private final SimpMessageSendingOperations messageTemplate;

}
