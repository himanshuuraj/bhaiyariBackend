package com.example.postgresdemo.service;

import com.example.postgresdemo.entity.Address;
import com.example.postgresdemo.entity.UserInfo;
import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.repository.AddressRepository;
import com.example.postgresdemo.repository.UserInfoRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        address1.setCity(address.getCity());
        address1.setState(address.getState());
        address1 = addressRepository.save(address1);
        return address1;
    }

    public Address deleteAddress(String userId, String addressId){
        Address address = addressRepository.findById(addressId).orElse(new Address());
        UserInfo userInfo = userInfoRepository.findById(userId).orElse(new UserInfo());
        if(userInfo.getUserId().equals(userId)) {
            List<Address> addressList = userInfo.getAddressList();
            addressList.remove(address);
            addressRepository.deleteById(addressId);
        } else  {
            System.out.println("User doesn't exist");
            return null;
        }
        return address;
    }

    public Address insertAddress(String userId, Address address){
        UserInfo userInfo = userInfoRepository.findById(userId).orElse(new UserInfo());
        List<Address> addressList = userInfo.getAddressList();
        address.setAddressId("");
        try {
            addressList.add(address);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        userInfo.setAddressList(addressList);
        userInfoRepository.save(userInfo);
        return address;
    }
}
