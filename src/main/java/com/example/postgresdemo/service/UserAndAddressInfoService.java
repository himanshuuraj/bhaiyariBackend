package com.example.postgresdemo.service;

import com.example.postgresdemo.entity.UserInfo;
import com.example.postgresdemo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAndAddressInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;
    public UserInfo getUserById(String id){
        UserInfo userInfo = userInfoRepository.findById(id).orElse(new UserInfo());
        return userInfo;
    }

}
