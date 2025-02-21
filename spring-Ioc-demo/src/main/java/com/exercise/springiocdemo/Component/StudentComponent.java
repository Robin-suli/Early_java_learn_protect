package com.exercise.springiocdemo.Component;

import com.exercise.springiocdemo.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class StudentComponent {
//    @Primary
    @Bean(value = {"ss1","ss2"})
    public Student s1(){
        return new Student("zhangsang",11);
    }

    @Bean
    public String name(){
        return "wangwu";
    }

    @Bean
    public String name2(){
        return "lisi2";
    }

    @Bean
    public Student s2(@Qualifier("name2") String n){
        return new Student(n, 18);
    }
}
