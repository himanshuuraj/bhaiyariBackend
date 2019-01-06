package com.example.postgresdemo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Address {

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    private AddressAndUserInfo addressAndUserInfo;

    @Id
    @NotNull
    private String addressId;

    private String line1;
}
