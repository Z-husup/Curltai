package com.example.curltai.Service;

import com.example.curltai.Dto.CommunityFeedDto;
import com.example.curltai.Dto.NewPostDto;
import com.example.curltai.Model.Community.Community;
import com.example.curltai.Model.Posts.Post;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Repository.PostRepository;
import com.example.curltai.Repository.UserRepository;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class FeedService {

    private final CommunityRepository communityRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public FeedService(CommunityRepository communityRepository, PostRepository postRepository,
                       UserRepository userRepository) {
        this.communityRepository = communityRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
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

    public Post createNewPost(NewPostDto newPostDto) {
        Date date = new Date();
        Post post = new Post();

        post.setCommunity(communityRepository.getById(newPostDto.getId_community()));
        post.setAuthor(userRepository.getById(newPostDto.getId_user()));
        post.setCreated_at(new Timestamp(date.getTime()));
        post.setBody(newPostDto.getText());
        post.setMembers_only(false);

        return postRepository.save(post);
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
