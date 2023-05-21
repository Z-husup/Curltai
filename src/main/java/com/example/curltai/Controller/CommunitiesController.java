package com.example.curltai.Controller;

import com.example.curltai.Dto.HomepageDto;
import com.example.curltai.Model.Users.User;
import com.example.curltai.Repository.CommentRepository;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Service.CommunityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CommunitiesController {

    private final CommunityRepository communityRepository;
    private final CommunityService commentService;

    public CommunitiesController(CommunityRepository communityRepository, CommunityService commentService) {
        this.communityRepository = communityRepository;
        this.commentService = commentService;
    }

    @GetMapping("/communities")
    public ResponseEntity getHomepageDto(@PathVariable User user) {
        HomepageDto homepageDto = new HomepageDto();
        homepageDto.setCommunities(communityRepository.findAll());
        homepageDto.setSubs((List) user.getCommunity());
        homepageDto.setUser(user);
        return ResponseEntity.ok(homepageDto);
    }

}
