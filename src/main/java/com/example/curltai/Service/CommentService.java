package com.example.curltai.Service;

import com.example.curltai.Dto.CommentsDto;
import com.example.curltai.Dto.NewCommentDto;
import com.example.curltai.Model.Posts.Comment;
import com.example.curltai.Model.Posts.Post;
import com.example.curltai.Repository.CommentRepository;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Repository.PostRepository;
import com.example.curltai.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    private final CommunityRepository communityRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public CommentService(CommunityRepository communityRepository,
                          PostRepository postRepository,
                          CommentRepository commentRepository,
                          UserRepository userRepository) {
        this.communityRepository = communityRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public CommentsDto getCommentDto(Long post_id) {
        Post post = postRepository.findById(post_id).orElseThrow();
        CommentsDto commentsDto = new CommentsDto();

        commentsDto.setComments(new ArrayList<>(post.getComments()));

        return commentsDto;
    }

    public Comment createNewComment(Long post_id, NewCommentDto newCommentDto) {
        Post post = postRepository.findById(post_id).orElseThrow();
        Comment comment = new Comment();
        Date date = new Date();

        comment.setBody(newCommentDto.getBody());
        comment.setPost(postRepository.getById(post_id));
        comment.setUser(userRepository.getById(newCommentDto.getId_author()));
        comment.setCreated_at(new Timestamp(date.getTime()));

        post.getComments().add(comment);
        postRepository.save(post);
        return comment;
    }

    public Comment deleteComment(Long comment_id) {
        Comment comment = commentRepository.findById(comment_id).orElseThrow();

        commentRepository.delete(commentRepository.getById(comment_id));

        return comment;
    }

}
