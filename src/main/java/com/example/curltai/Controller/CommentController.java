package com.example.curltai.Controller;

import com.example.curltai.Dto.CommentsDto;
import com.example.curltai.Dto.NewCommentDto;
import com.example.curltai.Model.Posts.Comment;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Repository.PostRepository;
import com.example.curltai.Service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

@RestController
public class CommentController {

    private final CommunityRepository communityRepository;
    private final PostRepository postRepository;
    private final CommentService commentService;

    public CommentController(CommunityRepository communityRepository, PostRepository postRepository, CommentService commentService) {
        this.communityRepository = communityRepository;
        this.postRepository = postRepository;
        this.commentService = commentService;
    }

    @GetMapping("/{community_id}/feed/{post_id}")
    public ResponseEntity getCommentDto(@PathVariable  Long post_id) {
        CommentsDto commentsDto = commentService.getCommentDto(post_id);
        return ResponseEntity.ok(commentsDto);
    }

    @PutMapping("/{community_id}/feed/{post_id}")
    public ResponseEntity createNewComment(@PathVariable  Long post_id, @RequestBody NewCommentDto newCommentDto) {
        Comment comment = commentService.createNewComment(post_id, newCommentDto);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/{community_id}/feed/{post_id}")
    public ResponseEntity deleteComment(@RequestBody  Long comment_id) {
        Comment comment = commentService.deleteComment(comment_id);
        return ResponseEntity.ok(comment);
    }
}
