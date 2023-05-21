package com.example.curltai.Controller;


import com.example.curltai.Dto.CommunityDto;
import com.example.curltai.Model.Posts.Post;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Service.CommunityService;
import com.example.curltai.Service.FeedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/feed")
public class FeedController {

    private final CommunityRepository communityRepository;
    private final FeedService feedService;

    public FeedController(CommunityRepository communityRepository, FeedService feedService) {
        this.communityRepository = communityRepository;
        this.feedService = feedService;
    }

    @GetMapping("/{community_id}/feed")
    public ResponseEntity getCommunityDto(@PathVariable Long community_id) {
        CommunityDto communityDto = feedService.getCommunitFeedyById(community_id);
        return ResponseEntity.ok(communityDto);
    }

    @PutMapping("/{community_id}/feed")
    public ResponseEntity updateUser(@PathVariable Long community_id, @RequestBody Post post) {


        return ResponseEntity.ok(post);
    }
}
