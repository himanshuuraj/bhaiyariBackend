package com.example.postgresdemo.service;

import com.example.postgresdemo.entity.Comment;
import com.example.postgresdemo.entity.Post;
import com.example.postgresdemo.repository.CommentRepository;
import com.example.postgresdemo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    public Comment insertCommentInComment(String commentId, Comment comment){
        Comment comment1 = commentRepository.findById(commentId).orElse(new Comment());
        List<Comment> commentList = comment1.getCommentList();
        comment.setCommentId("");
        commentList.add(comment);
        comment1.setCommentList(commentList);
        comment = commentRepository.save(comment1);
        return comment;
    }


}
