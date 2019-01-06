package com.example.postgresdemo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class UserAndPost {

    @Id
    @NotNull
    private String userAndPostId;

    private String userId;

    @OneToOne(cascade = CascadeType.ALL)
    private Post post;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAndPostId() {
        return userAndPostId;
    }

    public void setUserAndPostId(String userAndPostId) {
        this.userAndPostId = userAndPostId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
