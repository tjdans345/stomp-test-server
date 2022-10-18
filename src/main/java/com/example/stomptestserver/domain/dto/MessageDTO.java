package com.example.stomptestserver.domain.dto;

import lombok.*;

// {"type":"", "sender": "client1", "channelId":"eddy", "data":"test..."}

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MessageDTO {

    // 채팅 타입 ( ENTER (입장), SENDER(보내기) )
    private String type;

    // 보내는 사람
    private String sender;

    // 채팅방 이름 용도
    private String channelId;

    // 메시지 내용
    private Object data;

    @Builder
    public MessageDTO(String type, String sender, String channelId, Object data) {
        this.type = type;
        this.sender = sender;
        this.channelId = channelId;
        this.data = data;

        
    }

}
