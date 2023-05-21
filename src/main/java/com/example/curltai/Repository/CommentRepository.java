package com.example.curltai.Repository;

import com.example.curltai.Model.Posts.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
