package com.example.stomptestserver.controller;

import com.example.stomptestserver.domain.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageApiController {


    @GetMapping
    public void test(HttpServletResponse httpServletResponse) throws IOException {

        httpServletResponse.sendRedirect("https://www.naver.com/");
    }

    private final SimpMessageSendingOperations simpMessageSendingOperations;

    /**
     *  /pub/hello 메시지 발행
     *  /topic/channerId 구독
     */


    /**
     * 메시지 발행 메서드
     * @param messageDTO
     */
    // 여기서 이제 외부 메세지 브로커에 넣어주지 않을까 ? ? ? ? ? ? ? ? ? ? ? ? ? ?
    // 클라이언트에서, /pub/hello 로 메시지를 발행 함
    // 메시지 브로커 (현재 외부 브로커 연결)
    // Client 가 SEND 를 할 수 있는 경로
    @MessageMapping("/hello")
    public void message(@Payload MessageDTO messageDTO, SimpMessageHeaderAccessor headerAccessor) {

        log.info("message ??? : {} ",messageDTO.toString() );
        // topic/채널 아이디에 구독중인 클라이언트에게 메시지를 보냄
        if(headerAccessor != null && headerAccessor.getSessionAttributes() != null) {
            headerAccessor.getSessionAttributes().put("username", messageDTO.getSender());
        }

        // 메시지에 정의된 채널 id 에 메시지를 보낸다.
        simpMessageSendingOperations.convertAndSend("/topic/" + messageDTO.getChannelId(), messageDTO);

        // RabbitMQ 로직 짜야 할듯

    }








}
