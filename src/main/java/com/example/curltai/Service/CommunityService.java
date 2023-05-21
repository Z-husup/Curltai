package com.example.curltai.Service;

import com.example.curltai.Exception.CommunityNotFoundException;
import com.example.curltai.Interface.CommunityServiceInterface;
import com.example.curltai.Model.Community.Community;
import com.example.curltai.Repository.CommunityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService implements CommunityServiceInterface {
    private final CommunityRepository communityRepository;

    public CommunityService(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    public List<Community> getAllCommunities() {
        return communityRepository.findAll();
    }

    public Community getCommunityById(Long id) {
        return communityRepository.findById(id)
                .orElseThrow(() -> new CommunityNotFoundException("Community not found"));
    }
}
