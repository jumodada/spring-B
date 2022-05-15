package com.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBilibiliApp {

    public static void main(String[] args){
        ApplicationContext app = SpringApplication.run(SpringBilibiliApp.class, args);
    }

}
