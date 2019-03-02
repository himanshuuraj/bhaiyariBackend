package com.example.postgresdemo.repository;

import com.example.postgresdemo.entity.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, String> {
}
