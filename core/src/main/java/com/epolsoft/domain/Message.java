package com.epolsoft.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//todo not a jpa entity!
public class Message {
    private Long id;

    private String content;

    //Temp constructor
    public Message(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
