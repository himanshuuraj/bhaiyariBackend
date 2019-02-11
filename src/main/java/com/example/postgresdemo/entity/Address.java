package com.example.postgresdemo.entity;

import utils.UUIDClass;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Address {

    @ManyToOne
    private AddressAndUserInfo addressAndUserInfo;

    @Id
    @NotNull
    private String addressId;

    private String line1;

    private String line2;

    private String city;

    private String state;

    private String pinCode;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId){
        addressId = UUIDClass.getUUID("AD");
        this.addressId = addressId;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
