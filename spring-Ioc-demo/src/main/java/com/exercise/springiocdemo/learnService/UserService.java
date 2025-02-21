package com.exercise.springiocdemo.learnService;

import com.exercise.springiocdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Qualifier("s2")
    @Autowired
    private Student s1;




    public void print(){
        System.out.println("do Service");
        System.out.println(s1);
    }
}
