package com.example.postgresdemo.entity;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    private String postId;

    private String text;

    @OneToOne
    @PrimaryKeyJoinColumn
    private UserAndPost userAndPost;

}
