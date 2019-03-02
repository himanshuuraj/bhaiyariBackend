package com.example.postgresdemo.service;

import com.example.postgresdemo.entity.Address;
import com.example.postgresdemo.entity.Comment;
import com.example.postgresdemo.entity.Post;
import com.example.postgresdemo.entity.UserInfo;
import com.example.postgresdemo.repository.PostRepository;
import com.example.postgresdemo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Transactional
    public Post getPostById(String id){
        Post post = postRepository.findById(id).orElse(new Post());
        return post;
    }

    public Post savePost(Post post){
        post.setPostId("");
        if(post.getCommentList().size() > 0)
            post.getCommentList().forEach(item -> item.setCommentId(""));
        post = postRepository.save(post);
        return post;
    }

    public Post updatePost(String postId, Post post){
        Post post1 = postRepository.findById(postId).orElse(new Post());
        post.setUserId(post1.getPostId());
        post = postRepository.save(post);
        return post;
    }

    public Post deletePost(String postId){
        Post post = postRepository.findById(postId).orElse(new Post());
        postRepository.deleteById(postId);
        return post;
    }

    public List<Post> getPostList(int pageNumber){

        // pageNumber is the pageNumber starting from 0 and second argument is the pageSize

        Page<Post> posts = postRepository.findAll(PageRequest.of(pageNumber, 2));
        List<Post> list = posts.getContent();
//        List<UserInfo> list = (List<UserInfo>) userInfoRepository.findAll();
        return list;
    }

    public Post insertComment(String postId, Comment comment){
        Post post = postRepository.findById(postId).orElse(new Post());
        List<Comment>  commentList = post.getCommentList();
        comment.setCommentId("");
        commentList.add(comment);
        post.setCommentList(commentList);
        post = postRepository.save(post);
        return post;
    }

}
