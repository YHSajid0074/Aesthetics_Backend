package com.example.Aesthetic.controller;


import com.example.Aesthetic.dto.request.PostRequestDto;
import com.example.Aesthetic.dto.request.ProductRequestDto;
import com.example.Aesthetic.dto.response.PostsResponseDto;
import com.example.Aesthetic.model.posts.Posts;
import com.example.Aesthetic.service.PostService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.MediaType;
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

//    @PostMapping(value="/add", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
//    public ResponseEntity<String> addProduct(
//            // Handle image as MultipartFile
//            @ModelAttribute ProductRequestDto productRequestDto) { // Handle product details as request body
//        productService.add(productRequestDto, productRequestDto.file());
//        return ResponseEntity.ok("Product added successfully!");
//    }





    @PostMapping(value="/add", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<String> createPost(@ModelAttribute PostRequestDto postRequestDto) {
        postService.create(postRequestDto, postRequestDto.file());
        return ResponseEntity.ok("Post created");
    }

    @GetMapping("getById")
    public ResponseEntity<PostsResponseDto>getbById(@RequestParam Long id) {
      return ResponseEntity.ok( postService.findById(id));
    }

    @PutMapping(value="/update", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<String> updatePost(@ModelAttribute PostRequestDto postRequestDto,@RequestParam Long id) {
        postService.update(postRequestDto,id,postRequestDto.file());
        return ResponseEntity.ok("Post updated");
    }

    @GetMapping("GetAll")
    public ResponseEntity<Set<PostsResponseDto>> findAllPosts() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping(value="/findByTitle")
    public ResponseEntity<Set<PostsResponseDto>> findAllByTitle(@RequestParam String title) {
        return ResponseEntity.ok(postService.findByTitle(title));
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deletePost(Long id) {
        postService.delete(id);
        return ResponseEntity.ok("Post deleted");
    }
}
