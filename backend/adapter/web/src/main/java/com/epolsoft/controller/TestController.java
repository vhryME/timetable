package com.epolsoft.controller;

import com.epolsoft.domain.Message;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@AllArgsConstructor
public class TestController {
    //MessageUseCase useCase;

    @GetMapping("/greeting")
    public Message greeting() {
        System.out.println("Hello World!");

        Message message = new Message();

        message.setContent("Hello World!");

        return message;

        //return useCase.getMessageByContent("Hello World!!!");
    }

}
