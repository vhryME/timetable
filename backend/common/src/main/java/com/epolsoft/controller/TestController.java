package com.epolsoft.controller;

import com.epolsoft.domain.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/greeting")
    public Message greeting() {
        System.out.println("Hello World!");
        return new Message(1L, "Hello World!");
    }
}
