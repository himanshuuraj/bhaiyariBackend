package com.example.postgresdemo.entity;

import utils.UUIDClass;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
public class AddressAndUserInfo implements Serializable {

    @Id
    @NotNull
    private String addressAndUserInfoId;


    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> address;

    public String getAddressAndUserInfoId() {
        return addressAndUserInfoId;
    }

    public void setAddressAndUserInfoId(String addressAndUserInfoId) {
        addressAndUserInfoId = UUIDClass.getUUID("AdUs");
        this.addressAndUserInfoId = addressAndUserInfoId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private UserInfo userInfo;


}
