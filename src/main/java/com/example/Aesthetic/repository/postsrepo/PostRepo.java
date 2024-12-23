package com.example.Aesthetic.repository.postsrepo;


import com.example.Aesthetic.dto.response.PostsResponseDto;
import com.example.Aesthetic.model.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PostRepo extends JpaRepository<Posts, Long> {

    @Query("""
            SELECT p FROM Posts p
            WHERE p.id=:id
            """)
    public PostsResponseDto findPostById(Long id);

    @Query("""
            SELECT p
             FROM Posts p
             WHERE p.title LIKE %:title%
            """)

    public Set<PostsResponseDto> findByTitle(String title);

    @Query("""
             SELECT p
             FROM Posts p
            """)

    public Set<PostsResponseDto> findAllPosts();
    @Query("""
             SELECT p
             FROM Posts p
            """)

    public Set<Posts> findAllBy();
}
