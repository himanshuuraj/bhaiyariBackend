package com.example.postgresdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class CommentAndImage {

    @Id
    @NotNull
    private String commentAndImageId;

    private String commentId;

    @OneToOne(cascade = CascadeType.ALL)
    private Image image;
}
