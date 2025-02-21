package com.exercise.springiocdemo.rep;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public void print(){
        System.out.println("do Repository");
    }
}
