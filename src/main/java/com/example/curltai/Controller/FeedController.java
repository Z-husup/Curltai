package com.example.curltai.Controller;


import com.example.curltai.Dto.CommunityDto;
import com.example.curltai.Model.Posts.Post;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Service.CommunityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeedController {

    private final CommunityRepository communityRepository;
    private final CommunityService communityService;

    public FeedController(CommunityRepository communityRepository, CommunityService communityService) {
        this.communityRepository = communityRepository;
        this.communityService = communityService;
    }

    @GetMapping("/{community_id}/feed")
    public ResponseEntity getCommunityDto(@PathVariable Long community_id) {
        CommunityDto communityDto = communityService.getCommunitFeedyById(community_id);
        return ResponseEntity.ok(communityDto);
    }

    @PutMapping("/{community_id}/feed")
    public ResponseEntity updateUser(@PathVariable Long community_id, @RequestBody Post post) {


        return ResponseEntity.ok(post);
    }
}
