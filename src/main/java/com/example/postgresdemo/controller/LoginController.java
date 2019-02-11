package com.example.postgresdemo.controller;

import DtoRepository.UploadFileInS3;
import com.example.postgresdemo.entity.Address;
import com.example.postgresdemo.entity.UserInfo;
import com.example.postgresdemo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.UUIDClass;

@RestController
public class LoginController {

    @Autowired
    AddressRepository addressRepository;

    @RequestMapping("/")
    public String getData(){
        UploadFileInS3 uploadFileInS3 = new UploadFileInS3();
        String data = uploadFileInS3.uploadFile("", "");
        data += UUIDClass.getUUID("AR");
        return data;
    }

    @RequestMapping("/insert")
    public String insertIntoDatabase(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("1");
        userInfo.setName("name");

        Address address = new Address();
        address.getAddressId();
        address.setLine1("line1");

        //AddressAndUserInfo addressAndUserInfo = new AddressAndUserInfo();
        //addressAndUserInfo.setAddress(address);
        //addressAndUserInfo.setUserInfo(userInfo);
        //addressAndUserInfo.setAddressAndUserInfoId("1");
        //userAndAddressInfoRepository.save(addressAndUserInfo);
        return "success";
    }

    @RequestMapping("/hello")
    public String insertIntoAddress(){
        Address address = new Address();
        address.getAddressId();
        address.setLine1("line2");
        addressRepository.save(address);
        return "success";
    }

    @RequestMapping("/post")
    public String insertPost(){
        return "success";
    }

}
