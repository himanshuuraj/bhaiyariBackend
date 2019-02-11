package com.example.postgresdemo.controller;

import com.example.postgresdemo.entity.Address;
import com.example.postgresdemo.entity.UserInfo;
import com.example.postgresdemo.response.ResponseObject;
import com.example.postgresdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/getUserInfo/{id}")
    public ResponseObject getUserDetails(@PathVariable String id){
        ResponseObject responseObject = new ResponseObject();
        UserInfo userInfo = userInfoService.getUserById(id);
        if(userInfo.getName() == null)
            responseObject.setSuccessStatus(false);
        responseObject.setBody(userInfo);
        return responseObject;
    }

    @PostMapping("/insertUserInfo")
    public ResponseObject insertUserInfo(@RequestBody UserInfo userInfo){
        ResponseObject responseObject = new ResponseObject();
        UserInfo user = userInfoService.saveUser(userInfo);
        responseObject.setBody(user);
        return responseObject;
    }

    @PutMapping("/putUserInfo")
    public ResponseObject putUserInfo(@PathVariable String userId, @RequestBody UserInfo userInfo){
        ResponseObject responseObject = new ResponseObject();
        UserInfo user = userInfoService.updateUser(userId, userInfo);
        responseObject.setBody(user);
        return responseObject;
    }

    @DeleteMapping("/deleteUserInfo")
    public ResponseObject deleteUserInfo(@PathVariable String userId){
        ResponseObject responseObject = new ResponseObject();
        UserInfo userInfo = userInfoService.deleteUser(userId);
        responseObject.setBody(userInfo);
        return responseObject;
    }

    @GetMapping("/getAllUser/{pageNumber}")
    public ResponseObject getUserList(@PathVariable int pageNumber){
        ResponseObject responseObject = new ResponseObject();
        List<UserInfo> userInfoList = userInfoService.getUserInfoList(pageNumber);
        responseObject.setBody(userInfoList);
        return responseObject;
    }

    @PostMapping("/addAdress")
    public ResponseObject updateResponse(@RequestBody Address address){
        ResponseObject responseObject = new ResponseObject();
        //userInfoService.
        return responseObject;
    }

}
