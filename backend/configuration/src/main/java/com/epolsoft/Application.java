package com.epolsoft;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.TimeZone;


@SpringBootApplication(scanBasePackages = {"com.epolsoft.controller","com.epolsoft.mapper",
        "com.epolsoft.repo", "com.epolsoft.port"})
public class Application extends SpringBootServletInitializer {

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}