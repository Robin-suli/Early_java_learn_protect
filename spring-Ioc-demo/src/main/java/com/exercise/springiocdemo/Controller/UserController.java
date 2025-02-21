package com.exercise.springiocdemo.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping("login")
    public Boolean login(String name, String password, HttpSession session) {
        //1. 参数校验
        //2. 校验账号和密码是否正确
        //3. 设置session
        //4. 返回结果
        if (!StringUtils.hasLength(name) || !StringUtils.hasLength(password)){
            return false;
        }

        if ("ad".equals(name) && "ad".equals(password)){
            session.setAttribute("userName",name);
            return true;
        }

        return false;
    }
}

