package com.example.curltai.Controller;

import com.example.curltai.Dto.CommunityFeedDto;
import com.example.curltai.Dto.MediaDto;
import com.example.curltai.Model.Community.Community;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Service.MediaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping
public class MediaController {

    private final CommunityRepository communityRepository;
    private final MediaService mediaService;

    public MediaController(CommunityRepository communityRepository, MediaService mediaService) {
        this.communityRepository = communityRepository;
        this.mediaService = mediaService;
    }

    @GetMapping("/{community_id}/media")
    public ResponseEntity getMediaDto(@PathVariable Long community_id) {
        MediaDto mediaDto = mediaService.getMediaDto(community_id);
        return ResponseEntity.ok(mediaDto);
    }
}
