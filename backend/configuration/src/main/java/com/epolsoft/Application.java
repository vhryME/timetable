package com.epolsoft;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.match.domain.Player;
import com.epolsoft.match.domain.PlayerInMatch;
import com.epolsoft.match.domain.Statistic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.TimeZone;


@SpringBootApplication(scanBasePackages = {"com.epolsoft"})
public class Application extends SpringBootServletInitializer {

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }


    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}