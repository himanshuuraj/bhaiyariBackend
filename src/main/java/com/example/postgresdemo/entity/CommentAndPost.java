package com.example.postgresdemo.entity;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class CommentAndPost {

    @Id
    @NotNull
    private String commentAndPostId;

    @OneToOne(cascade = CascadeType.ALL)
    private Comment comment;

    private String  postId;
}
