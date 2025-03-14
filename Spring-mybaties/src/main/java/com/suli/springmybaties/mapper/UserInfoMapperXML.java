package com.suli.springmybaties.mapper;

import com.suli.springmybaties.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapperXML {

    List<UserInfo> selectAll();

    List<UserInfo> selectAll2();

    Integer insertUser(UserInfo userInfo);

    Integer insertUser2(UserInfo userInfo);

    Integer insertUser3(UserInfo userInfo);


    Integer insertUser4(List<UserInfo> userInfos);


    Integer updateUser(String password, Integer age, Integer id);

    Integer deleteUser(Integer id);

    Integer updateByConfition(UserInfo userInfo);

    List<UserInfo> selectByCondition(UserInfo userInfo);

    Integer batchDelete(List<Integer> ids);

}
