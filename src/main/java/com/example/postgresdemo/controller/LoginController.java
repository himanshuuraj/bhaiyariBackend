package com.example.postgresdemo.controller;

import com.example.postgresdemo.entity.Address;
import com.example.postgresdemo.entity.AddressAndUserInfo;
import com.example.postgresdemo.entity.UserInfo;
import com.example.postgresdemo.repository.AddressAndUserInfoRepository;
import com.example.postgresdemo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    AddressAndUserInfoRepository addressAndUserInfoRepository;
    @Autowired
    AddressRepository addressRepository;


    @RequestMapping("/insert")
    public String insertIntoDatabase(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("1");
        userInfo.setName("name");

        Address address = new Address();
        address.setAddressId("1");
        address.setLine1("line1");

        AddressAndUserInfo addressAndUserInfo = new AddressAndUserInfo();
        addressAndUserInfo.setAddress(address);
        addressAndUserInfo.setUserInfo(userInfo);
        addressAndUserInfo.setAddressAndUserInfoId("1");
        addressAndUserInfoRepository.save(addressAndUserInfo);
        return "success";
    }

    @RequestMapping("/hello")
    public String insertIntoAddress(){
        Address address = new Address();
        address.setAddressId("25");
        address.setLine1("line2");
        addressRepository.save(address);
        return "success";
    }

    @RequestMapping("/post")
    public String insertPost(){
        return "success";
    }

}
