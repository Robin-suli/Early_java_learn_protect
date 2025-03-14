package com.suli.springmybaties.mapper;

import com.suli.springmybaties.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserInfoMapperXMLTest {
    @Autowired
    private UserInfoMapperXML userInfoMapperXML;


    @Test
    void selectAll() {
        userInfoMapperXML.selectAll().stream().forEach(x-> System.out.println(x));
    }

    @Test
    void selectAll2() {
        userInfoMapperXML.selectAll().stream().forEach(x-> System.out.println(x));
    }

    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("厉飞羽");
        userInfo.setPassword("paopao");
        userInfo.setAge(10);

        Integer result = userInfoMapperXML.insertUser(userInfo);
        System.out.println("影响行数" + result + "自增:id" + userInfo.getId());
    }

    @Test
    void insertUser2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("韩天尊");
        userInfo.setPassword("救苦救难");
        userInfo.setAge(20);

        Integer result = userInfoMapperXML.insertUser2(userInfo);
        System.out.println("影响行数" + result + "自增id=" + userInfo.getId());
    }

    @Test
    void updateUser() {
        Integer result = userInfoMapperXML.updateUser("666",12,10);
        System.out.println("影响行数" + result);
    }

    @Test
    void deleteUser() {
        System.out.println(userInfoMapperXML.deleteUser(1));
    }

    @Test
    void insertUser3() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("月儿");
        userInfo.setPassword("111");
        userInfo.setGender(2);
        userInfo.setAge(10);

        Integer result = userInfoMapperXML.insertUser3(userInfo);
        System.out.println(result);
    }

    @Test
    void selectByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setDeleteFlag(8);
        userInfo.setPhone("88");
            userInfoMapperXML.selectByCondition(userInfo).stream().forEach(x-> System.out.println(x));
    }

    @Test
    void updateByConfition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(22);
        userInfo.setId(20);
        userInfo.setPassword("22");
        userInfo.setGender(22);

        Integer result = userInfoMapperXML.updateByConfition(userInfo);
        System.out.println("影响行数" + result);
    }

    @Test
    void batchDelete() {
        List<Integer> ids = List.of(8,9);
        userInfoMapperXML.batchDelete(ids);
    }

    @Test
    void insertUser4() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("消炎");
        userInfo.setPassword("xxx");
        userInfo.setAge(14);

        UserInfo userInfo1 = new UserInfo();

        userInfo1.setUsername("小医仙");
        userInfo1.setPassword("www");
        userInfo1.setAge(11);

        List<UserInfo> us = List.of(userInfo,userInfo1);
        Integer result = userInfoMapperXML.insertUser4(us);
        System.out.println("影响行数" + result);
    }
}