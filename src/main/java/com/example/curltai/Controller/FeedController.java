package com.example.curltai.Controller;


import com.example.curltai.Dto.CommunityFeedDto;
import com.example.curltai.Model.Posts.Post;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Service.FeedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class FeedController {

    private final CommunityRepository communityRepository;
    private final FeedService feedService;

    public FeedController(CommunityRepository communityRepository, FeedService feedService) {
        this.communityRepository = communityRepository;
        this.feedService = feedService;
    }

    @GetMapping("/{community_id}/feed")
    public ResponseEntity getCommunityDto(@PathVariable Long community_id) {
        // Получение данных о ленте сообщества по идентификатору community_id
        CommunityFeedDto communityFeedDto = feedService.getCommunitFeedyById(community_id);
        // Возвращение объекта communityFeedDto в ответе с кодом 200 OK
        return ResponseEntity.ok(communityFeedDto);
    }

    @PutMapping("/{community_id}/feed")
    public ResponseEntity likePost(@PathVariable Long community_id, @RequestBody Post post) {
        // Добавление лайка к посту с идентификатором post.getId_post() в сообществе с идентификатором community_id
        feedService.addLikeToPost(post.getId_post());
        // Возвращение объекта post в ответе с кодом 200 OK
        return ResponseEntity.ok(post);
    }


}
