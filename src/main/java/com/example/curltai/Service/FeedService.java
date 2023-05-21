package com.example.curltai.Service;

import com.example.curltai.Dto.CommunityDto;
import com.example.curltai.Model.Community.Community;
import com.example.curltai.Repository.CommunityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FeedService {

    private final CommunityRepository communityRepository;

    public FeedService(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    public CommunityDto getCommunitFeedyById(Long communityId) {
        Community community = communityRepository.findById(communityId).orElseThrow();
        CommunityDto communityDto = new CommunityDto();
        communityDto.setPosts(new ArrayList<>(community.getPost()));
        communityDto.setArtists(new ArrayList<>(community.getArtist()));
        communityDto.setImage(community.getImage());
        communityDto.setMembership(community.getMembership());

        return communityDto;
    }
}
