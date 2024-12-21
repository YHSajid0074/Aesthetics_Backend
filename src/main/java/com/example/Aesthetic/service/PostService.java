package com.example.Aesthetic.service;


import com.example.Aesthetic.dto.request.PostRequestDto;
import com.example.Aesthetic.dto.response.PostsResponseDto;
import com.example.Aesthetic.model.posts.Posts;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    public void create(PostRequestDto postRequestDto, MultipartFile file);
    public PostsResponseDto findById(Long id);
    public List<PostsResponseDto> findAll();
    public void update(PostRequestDto postRequestDto,Long id, MultipartFile file);
    public void delete(Long id);
    public List<PostsResponseDto> findByTitle(String title);
}
