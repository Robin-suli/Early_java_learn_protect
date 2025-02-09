package com.practice.spring_boot_practice;

import lombok.Data;
import lombok.Getter;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
public class UserInfo {
    private String name;
    private int age;
    private boolean gander;


    public UserInfo(String name, int age, boolean gander) {
        this.name = name;
        this.age = age;
        this.gander = gander;
    }

    public UserInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGander() {
        return gander;
    }

    public void setGander(boolean gander) {
        this.gander = gander;
    }

    @Override
    public String toString() {
        return "UserInfo{ " +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gander=" + gander +
                '}';
    }


}
