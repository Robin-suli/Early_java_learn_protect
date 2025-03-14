package com.suli.springmybaties.mapper;

import com.suli.springmybaties.model.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /*@Test
    void selectAll() {
        System.out.println(userInfoMapper.selectAll());
    }*/





   /* @BeforeEach
    void setUp() {
        System.out.println("测试之前");
    }

    @AfterEach
    void tearDown() {
        System.out.println("测试之后");
    }*/


    @Test
    void selectAllById() {
        System.out.println(userInfoMapper.selectAllById(3));
    }

    @Test
    void selectAllById2() {
        System.out.println(userInfoMapper.selectAllById(2));
    }

    @Test
    void selectByNameAndPassword() {
        userInfoMapper.selectByNameAndPassword("zhangsan","zhangsan").stream().forEach(x-> System.out.println(x));
    }

    @Test
    void selectByNameAndPassword2() {
        userInfoMapper.selectByNameAndPassword("lisi","lisi").stream().forEach(x-> System.out.println(x));

    }

    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("韩立");
        userInfo.setPassword("1243");
        userInfo.setAge(100);
        Integer result = userInfoMapper.insertUser(userInfo);
        System.out.println("影响行数" + result + " id " + userInfo.getId());
    }

    @Test
    void insertUser2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("风希大善人");
        userInfo.setPassword("123");
        userInfo.setAge(102);
        Integer result = userInfoMapper.insertUser(userInfo);
        System.out.println("影响行数" + result + " id " + userInfo.getId());
    }

    @Test
    void selectAllById3() {
        System.out.println(userInfoMapper.selectAllById3(11));
    }

    @Test
    void selectByNameAndPassword3() {
        //sql注入
        userInfoMapper.selectByNameAndPassword3("风希大善人","1243' or 1='1").stream().forEach(x-> System.out.println(x));
    }

    @Test
    void selectUserInfoByOrder() {
        userInfoMapper.selectUserInfoByOrder("asc").stream().forEach(x-> System.out.println(x));
    }


    @Test
    void selectUserInfoByLike() {
        userInfoMapper.selectUserInfoByLike("韩立").stream().forEach(x-> System.out.println(x));
    }
}