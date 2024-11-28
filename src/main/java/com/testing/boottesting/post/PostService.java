package com.testing.boottesting.post;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final RestClient restClient;

    public PostService() {
        System.out.println("Hello from PostService");
        restClient = RestClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }


    public List<Post> findAll() {
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {
                });
    }

    public Optional<Post> findById(int id) {
        return Optional.ofNullable(restClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .body(Post.class));
    }

    public Post create(Post post) {
        return restClient.post()
                .uri("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .body(Post.class);
    }

    public Optional<Post> update(int id, Post post) {
        return Optional.ofNullable(restClient.put()
                .uri("/posts/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .body(Post.class));
    }

    public void delete(int id) {
        restClient.delete()
                .uri("/posts/{id}", id)
                .retrieve()
                .toBodilessEntity();
    }

    private void init() {
        System.out.println("Hello from PostService.init ");
    }
}