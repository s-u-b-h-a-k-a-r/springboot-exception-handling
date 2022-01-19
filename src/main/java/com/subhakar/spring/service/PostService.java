package com.subhakar.spring.service;

import com.subhakar.spring.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post savePost(Post post);

    Optional<Post> getPostById(long id);

    List<Post> getAllPosts();
}
