package com.subhakar.spring.service;

import com.subhakar.spring.model.Post;
import com.subhakar.spring.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> getPostById(long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
