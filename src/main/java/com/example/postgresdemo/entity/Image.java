package com.example.postgresdemo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Image {

    @Id
    @NotNull
    private String imageId;

    private String imageUrl;

    @OneToOne
    @PrimaryKeyJoinColumn
    private UserAndImage userAndImage;
}
