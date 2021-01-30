package com.youngsuk.justbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
public class JustbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(JustbookApplication.class, args);
    }
}
