package com.testing.boottesting.post;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/posts")
@RestController
public class PostController {

    private final PostService postService;

//    @Value("#{'${spring.data.cluster.nodes:localhost:6379}'}")
//@Value("#{'${spring.redis.cluster}'.split(',') ?: 'localhost:6379'}")
//@Value("#{systemProperties['spring.redis.cluster.nodes'] ?: 'localhost:6379'}")
@Value("${spring.data.cluster.nodes:localhost6379}")
    String values;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public List<Post> getPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Post> getPost(@PathVariable int id) {
        return postService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.create(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post post) {
        return ResponseEntity.ok(postService.update(id, post).orElseThrow());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable int id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public String toString() {
        return "PostController{" +
                "values=" + values +
                '}';
    }
}
