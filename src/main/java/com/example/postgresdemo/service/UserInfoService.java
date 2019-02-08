package com.example.postgresdemo.service;

import com.example.postgresdemo.entity.UserInfo;
import com.example.postgresdemo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;
    public UserInfo getUserById(String id){
        UserInfo userInfo = userInfoRepository.findById(id).orElse(new UserInfo());
        return userInfo;
    }

    public UserInfo saveUser(UserInfo user){
        user.getUserId();
        UserInfo userInfo = userInfoRepository.save(user);
        return userInfo;
    }

    public UserInfo updateUser(String userId, UserInfo user){
        UserInfo userInfo = userInfoRepository.findById(userId).orElse(new UserInfo());
        userInfo.setName(user.getName());
        userInfo.setEmail(user.getEmail());
        userInfo.setPhone(user.getPhone());
        userInfo.setGender(user.getGender());
        userInfoRepository.save(userInfo);
        return userInfo;
    }

    public UserInfo deleteUser(String userId){
        UserInfo userInfo = userInfoRepository.findById(userId).orElse(new UserInfo());
        userInfo.setStatus(false);
        return userInfo;
    }
}
