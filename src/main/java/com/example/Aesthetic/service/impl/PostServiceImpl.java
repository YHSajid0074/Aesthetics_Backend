package com.example.Aesthetic.service.impl;

import com.example.Aesthetic.dto.request.PostRequestDto;
import com.example.Aesthetic.dto.response.PostsResponseDto;
import com.example.Aesthetic.model.posts.Posts;
import com.example.Aesthetic.repository.postsrepo.PostRepo;
import com.example.Aesthetic.service.PostService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    PostRepo postRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public Posts ConvertToEntity(PostRequestDto postRequestDto, Posts posts, MultipartFile file) {
        posts.setContent(postRequestDto.content());
        posts.setTitle(postRequestDto.title());
        if (file != null && !file.isEmpty()) {
            posts.setImageName(file.getOriginalFilename()); // Set original file name
            posts.setImageType(file.getContentType()); // Set content type (e.g., image/jpeg)
            try {
                posts.setImage(file.getBytes());
            } catch (Exception e) {
                throw new RuntimeException("Error saving image file: " + e.getMessage());
            }
        }

        return posts;
    }


    @Override
    public void create(PostRequestDto postRequestDto,MultipartFile file) {
        Posts posts = ConvertToEntity(postRequestDto, new Posts(),file);
        postRepo.save(posts);
    }

    @Override
    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts post= postRepo.findById(id).get();
        return new PostsResponseDto() {
            @Override
            public String getTitle() {
                return post.getTitle();
            }

            @Override
            public String getContent() {
                return post.getContent();
            }

            @Override
            public String getImageName() {
                return post.getImageName();
            }

            @Override
            public String getImageType() {
                return post.getImageType();
            }

            @Override
            public byte[] getImage() {
                return post.getImage();
            }

        };
    }


    @Override
    @Transactional
    public Set<PostsResponseDto> findAll() {
        Set<Posts> posts = postRepo.findAllBy();

        return posts.stream()
                .map(post -> new PostsResponseDto() {

                    @Override
                    public String getTitle() {
                        return post.getTitle(); // Get the title from the post entity
                    }

                    @Override
                    public String getContent() {
                        return post.getContent(); // Get the content from the post entity
                    }

                    @Override
                    public String getImageName() {
                        return post.getImageName(); // Get the image name from the post entity
                    }

                    @Override
                    public String getImageType() {
                        return post.getImageType(); // Get the image type from the post entity
                    }

                    @Override
                    public byte[] getImage() {
                        return post.getImage(); // Get the image byte array from the post entity
                    }
                })
                .collect(Collectors.toSet());
    }


    @Override
    @Transactional
    public void update(PostRequestDto postRequestDto, Long id,MultipartFile file) {
        Posts posts = postRepo.findById(id).get();
        Posts Update = ConvertToEntity(postRequestDto, posts,file);
        postRepo.save(Update);
    }

    @Override
    public void delete(Long id) {
     postRepo.deleteById(id);
    }

    @Override
    public Set<PostsResponseDto> findByTitle(String title) {
        return postRepo.findByTitle(title);
    }

}
