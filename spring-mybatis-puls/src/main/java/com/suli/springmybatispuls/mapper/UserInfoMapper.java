package com.suli.springmybatispuls.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.suli.springmybatispuls.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    @Select("select id, username, password, age from user_info ${ew.customSqlSegment}")
    List<UserInfo> selectUserInfoByCondition(@Param(Constants.WRAPPER) Wrapper<UserInfo> query);

    @Update("update user_info set age = age + #{addZge} ${ew.customSqlSegment}")
    Integer updateById(Integer addZge, @Param(Constants.WRAPPER) Wrapper<UserInfo> query);
}
