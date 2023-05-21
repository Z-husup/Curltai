package com.example.curltai.Service;

import com.example.curltai.Dto.CommunityFeedDto;
import com.example.curltai.Dto.MediaDto;
import com.example.curltai.Model.Community.Community;
import com.example.curltai.Repository.CommunityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MediaService {

    private final CommunityRepository communityRepository;

    public MediaService(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    public MediaDto getMediaDto(Long communityId) {
        Community community = communityRepository.findById(communityId).orElseThrow();
        MediaDto mediaDto = new MediaDto();
        mediaDto.setMedia(new ArrayList<>(community.getMedia()));
        mediaDto.setMembership(community.getMembership());
        return mediaDto;
    }
}
