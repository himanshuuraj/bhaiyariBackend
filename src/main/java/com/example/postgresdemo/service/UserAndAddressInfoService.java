package com.example.postgresdemo.service;

import com.example.postgresdemo.entity.UserInfo;
import com.example.postgresdemo.repository.UserAndAddressInfoRepository;
import com.example.postgresdemo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserAndAddressInfoService {

    @Autowired
    UserAndAddressInfoRepository userAndAddressInfoRepository;


}
