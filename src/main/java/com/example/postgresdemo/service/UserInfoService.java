package com.example.postgresdemo.service;

import com.amazonaws.services.dynamodbv2.datamodeling.AbstractDynamoDBMapper;
import com.example.postgresdemo.entity.Address;
import com.example.postgresdemo.entity.UserInfo;
import com.example.postgresdemo.repository.UserInfoRepository;
import com.example.postgresdemo.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    public UserInfo getUserById(String id){
        UserInfo userInfo = userInfoRepository.findById(id).orElse(new UserInfo());
        return userInfo;
    }

    public UserInfo saveUser(UserInfo user){
        user.setUserId("");
        if(user.getAddressList() != null)
            user.getAddressList().forEach(item -> {
                item.setAddressId("");
            });
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

    public List<UserInfo> getUserInfoList(int pageNumber){

        // pageNumber is the pageNumber starting from 0 and second argument is the pageSize

        Page<UserInfo> users = userInfoRepository.findAll(PageRequest.of(pageNumber, 2));
        List<UserInfo> list = users.getContent();
//        List<UserInfo> list = (List<UserInfo>) userInfoRepository.findAll();
        return list;
    }

    public Address saveAddress(String userId,Address address){

        UserInfo userInfo = userInfoRepository.findById(userId).orElse(new UserInfo());
        if(userInfo.getUserId() == null) return address;

//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserId(userId);
//        userInfo.setAddressList(new ArrayList<Address>(){
//        });
        return address;
    }

}
