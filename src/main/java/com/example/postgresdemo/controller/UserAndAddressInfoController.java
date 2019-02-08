package com.example.postgresdemo.controller;

import com.example.postgresdemo.entity.UserInfo;
import com.example.postgresdemo.response.ResponseObject;
import com.example.postgresdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAndAddressInfoController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/getUserInfoWithAddress/{id}")
    public ResponseObject getUserDetails(@PathVariable String id){
        ResponseObject responseObject = new ResponseObject();

        UserInfo userInfo = userInfoService.getUserById(id);
        if(userInfo.getName() == null)
            responseObject.setSuccessStatus(false);
        responseObject.setBody(userInfo);
        return responseObject;
    }

}
