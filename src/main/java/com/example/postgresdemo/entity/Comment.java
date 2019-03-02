package com.example.postgresdemo.entity;

import utils.UUIDClass;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Comment {

    @Id
    @NotNull
    private String commentId;

    private String text;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> commentList;

    @OneToOne
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        commentId = UUIDClass.getUUID("CO");
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}