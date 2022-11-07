package com.example.stomptestserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StompTestServerApplication {

    public static void main(String[] args) {
        System.out.println("Hello World !!!");
        SpringApplication.run(StompTestServerApplication.class, args);
    }

}
