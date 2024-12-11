package com.example.Aesthetic.service;


import com.example.Aesthetic.dto.request.PostRequestDto;
import com.example.Aesthetic.model.posts.Posts;

public interface PostService {
    public void create(PostRequestDto postRequestDto);
    public Posts findById(Long id);
}
