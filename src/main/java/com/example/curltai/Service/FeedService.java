package com.example.curltai.Service;

import com.example.curltai.Dto.CommunityFeedDto;
import com.example.curltai.Model.Community.Community;
import com.example.curltai.Model.Posts.Post;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FeedService {

    private final CommunityRepository communityRepository;
    private final PostRepository postRepository;

    public FeedService(CommunityRepository communityRepository, PostRepository postRepository) {
        this.communityRepository = communityRepository;
        this.postRepository = postRepository;
    }

    public CommunityFeedDto getCommunitFeedyById(Long communityId) {
        Community community = communityRepository.findById(communityId).orElseThrow();
        CommunityFeedDto communityFeedDto = new CommunityFeedDto();
        communityFeedDto.setPosts(new ArrayList<>(community.getFeedPosts()));
        communityFeedDto.setArtists(new ArrayList<>(community.getArtist()));
        communityFeedDto.setImage(community.getImage());
        communityFeedDto.setMembership(community.getMembership());

        return communityFeedDto;
    }

    public ResponseEntity addLikeToPost(Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            int currentLikes = post.getLikes();
            post.setLikes(currentLikes + 1);
            postRepository.save(post);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
