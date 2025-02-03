package com.dhana.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
public class BasicSpringApplicationJava {

    public static void main(String[] args) {

        SpringApplication.run(BasicSpringApplicationJava.class, args);
        System.out.println("Simple SpringBoot Security Application");
    }
}