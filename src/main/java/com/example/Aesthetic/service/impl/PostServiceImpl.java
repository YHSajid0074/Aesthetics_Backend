package com.example.Aesthetic.service.impl;

import com.example.Aesthetic.dto.request.PostRequestDto;
import com.example.Aesthetic.dto.response.PostsResponseDto;
import com.example.Aesthetic.model.posts.Posts;
import com.example.Aesthetic.repository.postsrepo.PostRepo;
import com.example.Aesthetic.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    PostRepo postRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public Posts ConvertToEntity(PostRequestDto postRequestDto, Posts posts) {
        posts.setContent(postRequestDto.content());
        posts.setTitle(postRequestDto.title());
        return posts;
    }


    @Override
    public void create(PostRequestDto postRequestDto) {
        Posts posts = ConvertToEntity(postRequestDto, new Posts());
        postRepo.save(posts);
    }

    @Override
    public PostsResponseDto findById(Long id) {
        return postRepo.findPostById(id);
    }

    @Override
    public List<PostsResponseDto> findAll() {
        return postRepo.findAllPosts();
    }

    @Override
    public void update(PostRequestDto postRequestDto, Long id) {
        Posts posts = postRepo.findById(id).get();
        Posts Update = ConvertToEntity(postRequestDto, posts);
        postRepo.save(Update);
    }

    @Override
    public void delete(Long id) {
     postRepo.deleteById(id);
    }

    @Override
    public List<PostsResponseDto> findByTitle(String title) {
        return postRepo.findByTitle(title);
    }

}
