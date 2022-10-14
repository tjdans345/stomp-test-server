package com.example.stomptestserver.domain.dto;

import lombok.*;

// {"type":"", "sender": "client1", "receiver":"b6268d02-ac43-fc6d-39bb-6e09151eb735", "data":"test..."}

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
