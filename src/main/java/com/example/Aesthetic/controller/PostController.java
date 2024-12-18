package com.example.Aesthetic.controller;


import com.example.Aesthetic.dto.request.PostRequestDto;
import com.example.Aesthetic.dto.response.PostsResponseDto;
import com.example.Aesthetic.model.posts.Posts;
import com.example.Aesthetic.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;

    }

    @PostMapping("CREATE")
    public ResponseEntity<String> createPost(PostRequestDto postRequestDto) {
        postService.create(postRequestDto);
        return ResponseEntity.ok("Post created");
    }

    @GetMapping("{id}")
    public ResponseEntity<PostsResponseDto>getbById(@PathVariable Long id) {
      return ResponseEntity.ok( postService.findById(id));
    }

    @PutMapping("update")
    public ResponseEntity<String> updatePost(PostRequestDto postRequestDto,Long id) {
        postService.update(postRequestDto,id);
        return ResponseEntity.ok("Post updated");
    }

    @GetMapping("GetAll")
    public ResponseEntity<List<PostsResponseDto>> findAllPosts() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("find/{title}")
    public ResponseEntity<List<PostsResponseDto>> findAllByTitle(String title) {
        return ResponseEntity.ok(postService.findByTitle(title));
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deletePost(Long id) {
        postService.delete(id);
        return ResponseEntity.ok("Post deleted");
    }
}
