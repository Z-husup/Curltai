package com.example.curltai.Controller;

import com.example.curltai.Dto.CommunityFeedDto;
import com.example.curltai.Model.Posts.Post;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Service.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ArtistController {
    private final CommunityRepository communityRepository;
    private final ArtistService artistService;

    public ArtistController(CommunityRepository communityRepository, ArtistService artistService) {
        this.communityRepository = communityRepository;
        this.artistService = artistService;
    }

    @GetMapping("/{community_id}/artist")
    public ResponseEntity getCommunityDto(@PathVariable Long community_id) {
        CommunityFeedDto communityFeedDto = artistService.getCommunityArtistFeedById(community_id);
        return ResponseEntity.ok(communityFeedDto);
    }

    @PutMapping("/{community_id}/artist")
    public ResponseEntity likePost(@PathVariable Long community_id, @RequestBody Post post) {
        artistService.addLikeToPost(post.getId_post());
        return ResponseEntity.ok(post);
    }
}
