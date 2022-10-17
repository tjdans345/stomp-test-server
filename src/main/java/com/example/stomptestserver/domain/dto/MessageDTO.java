package com.example.stomptestserver.domain.dto;

import lombok.*;

// {"type":"", "sender": "client1", "channelId":"eddy", "data":"test..."}

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MessageDTO {

    private String type;
    private String sender;
    private String channelId;
    private Object data;

    @Builder
    public MessageDTO(String type, String sender, String channelId, Object data) {
        this.type = type;
        this.sender = sender;
        this.channelId = channelId;
        this.data = data;
    }
}
