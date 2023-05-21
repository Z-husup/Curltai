package com.example.curltai.Controller;

import com.example.curltai.Dto.NewPostDto;
import com.example.curltai.Model.Posts.Post;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Service.FeedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private final CommunityRepository communityRepository;
    private final FeedService feedService;

    public PostController(CommunityRepository communityRepository, FeedService feedService) {
        this.communityRepository = communityRepository;
        this.feedService = feedService;
    }

    @PostMapping("/{community_id}/feed/postModal")
    public ResponseEntity createNewPost(@PathVariable NewPostDto newPostDto) {
        Post newPost = feedService.createNewPost(newPostDto);
        return ResponseEntity.ok(newPost);
    }

}
