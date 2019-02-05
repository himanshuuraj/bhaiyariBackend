package com.example.postgresdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity
public class Comment {

    @Id
    @NotNull
    private String commentId;

    @OneToOne
    @PrimaryKeyJoinColumn
    private UserAndComment userAndComment;

    @OneToOne
    @PrimaryKeyJoinColumn
    private CommentAndPost commentAndPost;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;

}