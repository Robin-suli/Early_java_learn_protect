package com.practice.spring_boot_practice;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    //既支持post又支持get
    @RequestMapping("m1")
    public String m1(){
        return "m1 hello spring boot";
    }

    //只支持get请求
    @RequestMapping(value = "m2",method = RequestMethod.GET)
    public String m2(){
        return "m2 hello spring boot";
    }
    @GetMapping("m22")
    public String m22(){
        return "m22 hello spring boot";
    }


    //只支持post请求
    @RequestMapping(value = "m3",method = RequestMethod.POST)
    public String m3(){
        return "m3 hello spring boot";
    }
    @PostMapping("m33")
    public String m33(){
        return "m33 hello spring boot";
    }

    //传数组
    @RequestMapping(value = "requestArr",method = {RequestMethod.GET,RequestMethod.POST})
    public String requestArr(){
        return "arr hello spring boot";
    }



}
