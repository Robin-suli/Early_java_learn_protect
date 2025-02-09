package com.practice.spring_boot_practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class JsonTest {
    @Test
    void test(){
        System.out.println("测试程序");
    }

    @Test
    void testObject20Json() throws JsonProcessingException {
        /**
         * java对象 转json对象
         */
        ObjectMapper objectMapper = new ObjectMapper();
        //创建java对象
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张三");
        userInfo.setAge(18);
        userInfo.setGander(false);

        //创建Json对象
        String js = objectMapper.writeValueAsString(userInfo);
        System.out.println(js);
    }

    @Test
    void testJson20Object() throws JsonProcessingException {
        /**
         * json对象 转java对象
         */
        ObjectMapper objectMapper = new ObjectMapper();

        //定义Json字符串
        String js = "{\"name\":\"张三\",\"age\":18,\"gander\":false}";
        System.out.println(js);
        //json 转对象
        UserInfo userInfo = objectMapper.readValue(js, UserInfo.class);
        System.out.println(userInfo);

    }

}
