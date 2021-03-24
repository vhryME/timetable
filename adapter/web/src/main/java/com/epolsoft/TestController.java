package com.epolsoft;

import com.epolsoft.domain.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestController {
    @GetMapping("/greeting")
    public Message greeting() {
        return new Message(1L, "Hello World!");
    }
}
