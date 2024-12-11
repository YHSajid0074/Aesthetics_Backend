package com.example.Aesthetic.repository.postsrepo;


import com.example.Aesthetic.model.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Posts,Long> {

}
