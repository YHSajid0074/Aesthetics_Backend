package com.example.Aesthetic.service.impl;

import com.example.Aesthetic.dto.request.PostRequestDto;
import com.example.Aesthetic.model.posts.Posts;
import com.example.Aesthetic.repository.postsrepo.PostRepo;
import com.example.Aesthetic.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    PostRepo postRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }


    @Override
    public void create(PostRequestDto postRequestDto) {
        Posts posts = new Posts();
        posts.setContent(postRequestDto.content());
        posts.setTitle(postRequestDto.title());
        postRepo.save(posts);

    }

    @Override
    public Posts findById(Long id) {
        return postRepo.findById(id).orElse(null);
    }
}
