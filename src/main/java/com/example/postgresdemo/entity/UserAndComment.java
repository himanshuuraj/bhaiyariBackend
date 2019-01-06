package com.example.postgresdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class UserAndComment {

    @Id
    @NotNull
    private String userAndCommentId;

    private String userId;

    @OneToOne(cascade = CascadeType.ALL)
    private Comment comment;

}
