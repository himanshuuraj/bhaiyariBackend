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

    @OneToOne(cascade = CascadeType.ALL)
    private Image image;
}
