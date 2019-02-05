package com.example.postgresdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class PostAndImage {

    @Id
    @NotNull
    private String postAndImageId;

    private String postId;

    @OneToOne(cascade = CascadeType.ALL)
    private Image image;

}
