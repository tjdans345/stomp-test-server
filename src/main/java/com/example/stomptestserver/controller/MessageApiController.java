package com.example.stomptestserver.controller;

import com.example.stomptestserver.domain.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageApiController {

    private final SimpMessageSendingOperations simpMessageSendingOperations;

    // 클라이언트에서, /pub/hello 로 메시지를 발행 함
    @MessageMapping("/hello")
    public void message(MessageDTO messageDTO) {

        log.info("message ??? : {} ",messageDTO.toString() );
        // 메시지에 정의된 채널 id 에 메시지를 보낸다.
        // queue/channel/채널 아이디에 구독중인 클라이언트에게 메시지를 보냄
        simpMessageSendingOperations.convertAndSend("/queue/channel/" + messageDTO.getChannelId(), messageDTO);
    }

}
