package com.example.postgresdemo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class AddressAndUserInfo implements Serializable {

    @Id
    @NotNull
    private String addressAndUserInfoId;


    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public String getAddressAndUserInfoId() {
        return addressAndUserInfoId;
    }

    public void setAddressAndUserInfoId(String addressAndUserInfoId) {
        this.addressAndUserInfoId = addressAndUserInfoId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
