package com.example.postgresdemo.service;

import com.example.postgresdemo.entity.Address;
import com.example.postgresdemo.entity.UserInfo;
import com.example.postgresdemo.repository.AddressRepository;
import com.example.postgresdemo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    public Address getAddress(String addressId){
        Address address = addressRepository.findById(addressId).orElse(new Address());
        return address;
    }

    public Address updateAddress(String addressId, Address address){
        Address address1 = addressRepository.findById(addressId).orElse(new Address());
        address.setAddressId(address1.getAddressId());
        return address;
    }

    public Address deleteAddress(String addressId){
        Address address = addressRepository.findById(addressId).orElse(new Address());
        try {
            addressRepository.deleteById(addressId);
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return address;
    }

    public Address insertAddress(String userId, Address address){
        UserInfo userInfo = userInfoRepository.findById(userId).orElse(new UserInfo());
        List<Address> addressList = userInfo.getAddressList();
        addressList.add(address);
        userInfoRepository.save(userInfo);
        return address;
    }
}
