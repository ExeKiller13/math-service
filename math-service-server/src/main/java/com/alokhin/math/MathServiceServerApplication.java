package com.alokhin.math;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class MathServiceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MathServiceServerApplication.class, args);
    }
}
