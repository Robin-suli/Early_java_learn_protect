package com.exercise.springiocdemo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("ss")
@RestController
public class PropertiesController {

    @Value("${my.key}")
    private Integer myKey;


    @RequestMapping("re")
    public String readValue(){
        return " 读配置文件myKey " + myKey;
    }

}
