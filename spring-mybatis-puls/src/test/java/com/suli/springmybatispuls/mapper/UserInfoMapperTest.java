package com.suli.springmybatispuls.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.suli.springmybatispuls.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("hhh");
        userInfo.setPassword("333");
        userInfo.setAge(15);
        userInfo.setPhone("1519");
        userInfoMapper.insert(userInfo);
    }

    @Test
    void selectByCondition() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id,username,password,age,delete_flag")
                .eq("age", 100)
                .like("username", "韩");
        userInfoMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    void selectByCondition2() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select(UserInfo::getId, UserInfo::getUsername,
                UserInfo::getPassword, UserInfo::getAge, UserInfo::getDeleteFlag)
                .eq(UserInfo::getAge, 15)
                .like(UserInfo::getUsername, "风");
        userInfoMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    void updateByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setDeleteFlag(1);

        //age<100
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("age", 100);

        userInfoMapper.update(userInfo, queryWrapper);
    }

    @Test
    void updateByCondition2() {
        UpdateWrapper<UserInfo> userInfoUpdateWrapper = new UpdateWrapper<>();

        userInfoUpdateWrapper.set("delete_flag", 0)
                .lt("age", 100);

        userInfoMapper.update(userInfoUpdateWrapper);
    }

    @Test
    void updateByCondition3() {
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("delete_flag", 1).set("age", 2)
                .in("id", List.of(3, 4, 5));

        userInfoMapper.update(updateWrapper);
    }

    //基于sql更新
    @Test
    void updateByCondition4() {
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.setSql("age = age+30")
                .in("id", List.of(3, 4, 5));
        userInfoMapper.update(updateWrapper);
    }

    @Test
    void updateByCondition5() {
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(UserInfo::getDeleteFlag,3)
                .lt(UserInfo::getAge,20);
        userInfoMapper.update(updateWrapper);

    }

    @Test
    void updateByCondition6() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", List.of(51,52));

        userInfoMapper.updateById(5,queryWrapper);
    }

        @Test
    void deleteByCondition(){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age",1);
        userInfoMapper.delete(queryWrapper);
    }

    //自定义Sql
    @Test
    void selectUserInfoByCondition(){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("age", 100);

        userInfoMapper.selectUserInfoByCondition(queryWrapper);
    }
}
