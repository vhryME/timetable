package com.epolsoft.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Message {
    private Long id;

    private String content;

    //Temp constructor
    public Message(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
