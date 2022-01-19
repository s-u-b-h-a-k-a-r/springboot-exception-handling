package com.subhakar.spring;

import com.github.javafaker.Faker;
import com.subhakar.spring.model.Post;
import com.subhakar.spring.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final PostService postService;

    @Override
    public void run(String... args) throws Exception {
        IntStream.range(1, 50).forEach(i -> {
            savePost(new Faker());
            displayPosts();
        });
    }

    private void displayPosts() {
        postService.getAllPosts().forEach(System.out::println);
    }

    private void savePost(Faker faker) {
        postService.savePost(
                Post.builder()
                        .title(faker.harryPotter().book())
                        .description(faker.harryPotter().quote())
                        .build()
        );
    }
}
