package com.example.curltai.Repository;

import com.example.curltai.Model.Posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
