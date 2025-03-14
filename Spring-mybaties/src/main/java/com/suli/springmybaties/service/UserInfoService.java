package com.suli.springmybaties.service;

import com.suli.springmybaties.mapper.UserInfoMapper;
import com.suli.springmybaties.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;


    public UserInfo getUserInfoMapper(Integer id) {
        return userInfoMapper.selectAllById(id);
    }
}
