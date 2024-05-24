package com.rushiwarade.thymeleafspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.rushiwarade"})
public class ThymeleafSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafSpringBootApplication.class, args);
    }

}
