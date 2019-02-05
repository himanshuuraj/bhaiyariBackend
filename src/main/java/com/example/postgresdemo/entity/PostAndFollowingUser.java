package com.example.postgresdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class PostAndFollowingUser {

    @Id
    @NotNull
    private String postAndFollowingUserId;

    private String userIn;

    private String followingUserId;

}
