package com.example.postgresdemo.controller;

import com.example.postgresdemo.entity.Address;
import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.repository.AddressRepository;
import com.example.postgresdemo.response.ResponseObject;
import com.example.postgresdemo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @Autowired
    AddressRepository addressRepositoryy;

    @GetMapping("/getAddress/{id}")
    public ResponseObject getAddress(@PathVariable String id) {
        ResponseObject responseObject = new ResponseObject();
        Address address = addressService.getAddress(id);
        responseObject.setBody(address);
        return responseObject;
    }

    @PutMapping("/updateAddress/{id}")
    public ResponseObject updateAddress(@PathVariable String id, @RequestBody Address updatedAddress) {
        ResponseObject responseObject = new ResponseObject();
        Address address = addressService.updateAddress(id, updatedAddress);
        responseObject.setBody(address);
        return responseObject;
//        String ids = addressService.getAddress(id).getAddressId();
//        return addressRepositoryy.findById(id).map(addressUp -> {
//            addressUp.setAddressId(ids);
//            addressUp.setLine1(updatedAddress.getLine1());
//            addressUp.setLine2(updatedAddress.getLine2());
//            addressUp.setCity(updatedAddress.getCity());
//            addressUp.setState(updatedAddress.getState());
//            addressUp.setPinCode(updatedAddress.getPinCode());
//            return addressRepositoryy.save(updatedAddress);
//        }).orElseThrow(() -> new ResourceNotFoundException("Address not found with id " + id));
    }

    @PostMapping("/addAddress/{id}")
    public ResponseObject insertAddress(@PathVariable  String id, @RequestBody Address insertAddress) {
        ResponseObject responseObject = new ResponseObject();
        Address address = addressService.insertAddress(id, insertAddress);
        responseObject.setBody(address);
        return responseObject;
    }

    @DeleteMapping("/deleteAddress/{userId}/{addressId}")
    public ResponseObject deleteAddress(@PathVariable String userId, @PathVariable String addressId) {
        ResponseObject responseObject = new ResponseObject();
        Address address = addressService.deleteAddress(userId, addressId);
        responseObject.setBody(address);
        return responseObject;
    }

}
