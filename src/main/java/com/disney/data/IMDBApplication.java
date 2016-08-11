package com.disney.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IMDBApplication {

    public static void main(String[] args) {
        SpringApplication.run(IMDBApplication.class, args);
    }
}
