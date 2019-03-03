package com.example.postgresdemo.repository;

import com.example.postgresdemo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {
}
