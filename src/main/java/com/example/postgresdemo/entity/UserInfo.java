package com.example.postgresdemo.entity;

import constants.USER_TYPE;
import utils.UUIDClass;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class UserInfo {

    @Id
    @NotNull
    public String userId;

    @OneToOne
    @PrimaryKeyJoinColumn
    private UserAndPost userAndPost;

    private String name;

    private String email;

    private String phone;

    private String gender;

    private Boolean status = true;

    private String userType = USER_TYPE.END_USER;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addressList;

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        userId = UUIDClass.getUUID("US");
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
