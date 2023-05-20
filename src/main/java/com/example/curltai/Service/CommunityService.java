package com.example.curltai.Service;

import com.example.curltai.Dto.CommunityDto;
import com.example.curltai.Exception.CommunityNotFoundException;
import com.example.curltai.Interface.CommunityServiceInterface;
import com.example.curltai.Model.Community.Community;
import com.example.curltai.Repository.CommunityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityService implements CommunityServiceInterface {
    private final CommunityRepository communityRepository;

    public CommunityService(CommunityRepository communityRepository) {
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

    public List<Community> getAllCommunities() {
        return communityRepository.findAll();
    }
    public Community getCommunityById(Long id) {
        return communityRepository.findById(id)
                .orElseThrow(() -> new CommunityNotFoundException("Community not found"));
    }
}
