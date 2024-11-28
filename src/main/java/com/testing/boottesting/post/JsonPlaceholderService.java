package com.testing.boottesting.post;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;
import java.util.Optional;

public interface JsonPlaceholderService {

    @GetExchange("/posts")
    List<Post> findAll();

    @GetExchange("/posts/{id}")
    Optional<Post> findById(Integer id);

    @PostExchange("/posts")
    Post create(Post post);

    @PutExchange("/posts/{id}")
    Optional<Post> update(@PathVariable Integer id, Post post);

    @DeleteMapping("/posts/{id}")
    void delete(@PathVariable Integer id);

}