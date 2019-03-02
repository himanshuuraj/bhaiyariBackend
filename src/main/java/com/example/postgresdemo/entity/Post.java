package com.example.postgresdemo.entity;

import utils.UUIDClass;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post {

    @Id
    private String postId;

    private String userId;

    private String text;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> imageList;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Comment> commentList;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        postId = UUIDClass.getUUID("PO");
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
