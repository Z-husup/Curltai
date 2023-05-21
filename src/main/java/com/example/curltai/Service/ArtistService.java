package com.example.curltai.Service;

import com.example.curltai.Dto.CommunityFeedDto;
import com.example.curltai.Dto.NewArtistPostDto;
import com.example.curltai.Dto.NewPostDto;
import com.example.curltai.Model.Community.Community;
import com.example.curltai.Model.Posts.Post;
import com.example.curltai.Repository.ArtistRepository;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class ArtistService {

    private final CommunityRepository communityRepository;
    private final PostRepository postRepository;
    private final ArtistRepository artistRepository;

    public ArtistService(CommunityRepository communityRepository, PostRepository postRepository,
                         ArtistRepository artistRepository) {
        this.communityRepository = communityRepository;
        this.postRepository = postRepository;
        this.artistRepository = artistRepository;
    }

    public CommunityFeedDto getCommunityArtistFeedById(Long communityId) {
        Community community = communityRepository.findById(communityId).orElseThrow();
        CommunityFeedDto communityFeedDto = new CommunityFeedDto();

        communityFeedDto.setPosts(new ArrayList<>(community.getArtistPosts()));
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


    public Post createNewArtistPost(NewArtistPostDto newArtistPostDto) {
        Date date = new Date();
        Post post = new Post();

        post.setCommunity(communityRepository.getById(newArtistPostDto.getId_community()));
        post.setArtist(artistRepository.getById(newArtistPostDto.getId_artist()));
        post.setCreated_at(new Timestamp(date.getTime()));
        post.setBody(newArtistPostDto.getText());
        post.setMembers_only(newArtistPostDto.getMembers_only());

        return postRepository.save(post);
    }
}
