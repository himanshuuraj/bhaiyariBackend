package com.example.postgresdemo.service;

import com.example.postgresdemo.entity.Address;
import com.example.postgresdemo.entity.AddressAndUserInfo;
import com.example.postgresdemo.entity.UserInfo;
import com.example.postgresdemo.repository.UserAndAddressInfoRepository;
import com.example.postgresdemo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserAndAddressInfoService {

    @Autowired
    UserAndAddressInfoRepository userAndAddressInfoRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    public AddressAndUserInfo insertAddress(String userId, List<Address> addressList){

        UserInfo userInfo = userInfoRepository.findById(userId).orElse(new UserInfo());
        if(userInfo.name == null) return null;

        addressList.forEach(address -> address.setAddressId(""));

        AddressAndUserInfo addressAndUserInfo = new AddressAndUserInfo();
        addressAndUserInfo.setAddressAndUserInfoId("AdUs");
        addressAndUserInfo.setUserInfo(userInfo);
        addressAndUserInfo.setAddress(addressList);

        addressAndUserInfo = userAndAddressInfoRepository.save(addressAndUserInfo);

        return addressAndUserInfo;
    }

}
