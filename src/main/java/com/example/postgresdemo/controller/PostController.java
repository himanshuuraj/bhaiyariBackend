package com.example.postgresdemo.controller;

import com.example.postgresdemo.entity.Address;
import com.example.postgresdemo.entity.Comment;
import com.example.postgresdemo.entity.Post;
import com.example.postgresdemo.entity.UserInfo;
import com.example.postgresdemo.response.ResponseObject;
import com.example.postgresdemo.service.CommentService;
import com.example.postgresdemo.service.PostService;
import com.example.postgresdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @GetMapping("/getPost/{id}")
    public ResponseObject getPost(@PathVariable String postId){
        ResponseObject responseObject = new ResponseObject();
        Post post = postService.getPostById(postId);
        if(post.getPostId() == null)
            responseObject.setSuccessStatus(false);
        responseObject.setBody(post);
        return responseObject;
    }

    @PostMapping("/insertPost")
    public ResponseObject insertPost(@RequestBody Post post){
        ResponseObject responseObject = new ResponseObject();
        post = postService.savePost(post);
        responseObject.setBody(post);
        return responseObject;
    }

    @PutMapping("/putPost/{postId}")
    public ResponseObject putPost(@PathVariable String postId, @RequestBody Post post){
        ResponseObject responseObject = new ResponseObject();
        post = postService.updatePost(postId, post);
        responseObject.setBody(post);
        return responseObject;
    }

    @DeleteMapping("/deletePost")
    public ResponseObject deletePost(@PathVariable String postId){
        ResponseObject responseObject = new ResponseObject();
        Post post = postService.deletePost(postId);
        responseObject.setBody(post);
        return responseObject;
    }

    @GetMapping("/getAllPost/{pageNumber}")
    public ResponseObject getPostList(@PathVariable int pageNumber){
        ResponseObject responseObject = new ResponseObject();
        List<Post> postList = postService.getPostList(pageNumber);
        responseObject.setBody(postList);
        return responseObject;
    }

    @PostMapping("/insertComment")
    public ResponseObject insertComment(@PathVariable String postId, @RequestBody Comment comment){
        ResponseObject responseObject = new ResponseObject();
        Post post = postService.insertComment(postId, comment);
        responseObject.setBody(post);
        return responseObject;
    }

    @PostMapping("insertCommentIntoComment/{commentId}")
    public ResponseObject insertCommentIntoComment(@PathVariable String commentId, @RequestBody Comment comment){
        ResponseObject responseObject = new ResponseObject();
        comment = commentService.insertCommentInComment(commentId, comment);
        responseObject.setBody(comment);
        return responseObject;
    }

}
