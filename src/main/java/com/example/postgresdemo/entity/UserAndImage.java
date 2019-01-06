package com.example.postgresdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class UserAndImage {

    @Id
    @NotNull
    private String userAndImageId;

    private String userId;

    public String getUserAndImageId() {
        return userAndImageId;
    }

    public void setUserAndImageId(String userAndImageId) {
        this.userAndImageId = userAndImageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Image image;
}
