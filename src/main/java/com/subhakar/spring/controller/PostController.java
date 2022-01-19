package com.subhakar.spring.controller;

import com.subhakar.spring.exception.ResourceNotFoundException;
import com.subhakar.spring.model.Post;
import com.subhakar.spring.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostController {
    private final PostService postService;

    @PostMapping(value = "/posts")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        Post _post = postService.savePost(post);
        return new ResponseEntity(_post, HttpStatus.CREATED);
    }

    @GetMapping(value = "/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") long id) {
        Post _post = postService.getPostById(id).orElseThrow(new Supplier<ResourceNotFoundException>() {
            @Override
            public ResourceNotFoundException get() {
                return new ResourceNotFoundException("Not found Post with id = " + id);
            }
        });
        return ResponseEntity.ok(_post);
    }
}
