package com.example.postgresdemo.controller;

import com.example.postgresdemo.entity.Address;
import com.example.postgresdemo.entity.AddressAndUserInfo;
import com.example.postgresdemo.response.ResponseObject;
import com.example.postgresdemo.service.UserAndAddressInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserAndAddressInfoController {

    @Autowired
    UserAndAddressInfoService userAndAddressInfoService;

    @PostMapping("insertAddress/{userId}")
    public ResponseObject insertAddress(@PathVariable String userId, @RequestBody List<Address> addressList){
        ResponseObject responseObject = new ResponseObject();
        AddressAndUserInfo addressAndUserInfo = userAndAddressInfoService.insertAddress(userId, addressList);
        responseObject.setBody(addressAndUserInfo);
        return responseObject;
    }

}
