package com.example.postgresdemo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class UserInfo {

    @Id
    @NotNull
    public String userId;

    @OneToOne
    @PrimaryKeyJoinColumn
    private AddressAndUserInfo addressAndUserInfo;


    @OneToOne
    @PrimaryKeyJoinColumn
    private UserAndPost userAndPost;


    public AddressAndUserInfo getAddressAndUserInfo() {
        return addressAndUserInfo;
    }

    public void setAddressAndUserInfo(AddressAndUserInfo addressAndUserInfo) {
        this.addressAndUserInfo = addressAndUserInfo;
    }

    public UserAndPost getUserAndPost() {
        return userAndPost;
    }

    public void setUserAndPost(UserAndPost userAndPost) {
        this.userAndPost = userAndPost;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;
}
