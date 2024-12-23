package com.example.Aesthetic.controller;


import com.example.Aesthetic.dto.request.PostRequestDto;
import com.example.Aesthetic.dto.response.PostsResponseDto;
import com.example.Aesthetic.model.posts.Posts;
import com.example.Aesthetic.service.PostService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("post")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;

    }

    @PostMapping("CREATE")
    public ResponseEntity<String> createPost(@RequestBody PostRequestDto postRequestDto, MultipartFile file) {
        postService.create(postRequestDto,file);
        return ResponseEntity.ok("Post created");
    }

    @GetMapping("{id}")
    public ResponseEntity<PostsResponseDto>getbById(@PathVariable Long id) {
      return ResponseEntity.ok( postService.findById(id));
    }

    @PutMapping("update")
    public ResponseEntity<String> updatePost(PostRequestDto postRequestDto,MultipartFile file ,Long id) {
        postService.update(postRequestDto,id,file);
        return ResponseEntity.ok("Post updated");
    }

    @GetMapping("GetAll")
    public ResponseEntity<Set<PostsResponseDto>> findAllPosts() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("find/{title}")
    public ResponseEntity<Set<PostsResponseDto>> findAllByTitle(String title) {
        return ResponseEntity.ok(postService.findByTitle(title));
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deletePost(Long id) {
        postService.delete(id);
        return ResponseEntity.ok("Post deleted");
    }
}
