package com.example.Aesthetic.controller;


import com.example.Aesthetic.dto.request.PostRequestDto;
import com.example.Aesthetic.model.posts.Posts;
import com.example.Aesthetic.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Posts>getbById(@PathVariable Long id) {
      return ResponseEntity.ok( postService.findById(id));
    }
}
