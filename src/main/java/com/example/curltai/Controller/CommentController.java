package com.example.curltai.Controller;

import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Repository.PostRepository;

public class CommentController {

    private final CommunityRepository communityRepository;
    private final PostRepository postRepository;


    public CommentController(CommunityRepository communityRepository, PostRepository postRepository) {
        this.communityRepository = communityRepository;
        this.postRepository = postRepository;
    }
}
