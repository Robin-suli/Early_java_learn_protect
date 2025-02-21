package com.exercise.springiocdemo.config;

import org.springframework.context.annotation.Configuration;

@Configuration("reNameBean")
public class UserConfig {

    public void print(){
        System.out.println("do config");
    }
}
