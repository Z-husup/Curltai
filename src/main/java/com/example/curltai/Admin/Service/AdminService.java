package com.example.curltai.Admin.Service;

import com.example.curltai.Admin.Dto.NewCommunityDto;
import com.example.curltai.Admin.Entity.Ban;
import com.example.curltai.Admin.Entity.BanRepository;
import com.example.curltai.Exception.CommunityNotFoundException;
import com.example.curltai.Model.Community.Community;
import com.example.curltai.Model.Store.MembershipProduct;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Service.MembershipService;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final CommunityRepository communityRepository;
    private final MembershipService membershipService;
    private final BanRepository banRepository;

    public AdminService(CommunityRepository communityRepository, MembershipService membershipService, BanRepository banRepository) {
        this.communityRepository = communityRepository;
        this.membershipService = membershipService;
        this.banRepository = banRepository;
    }

    public Community createCommunity(NewCommunityDto newCommunityDto) {
        // Extract the required fields from the DTO
        String name = newCommunityDto.getName();
        String image = newCommunityDto.getImage();
        String description = newCommunityDto.getDescription();

        // Create a new Community object
        Community community = new Community();
        community.setName(name);
        community.setImage(image);
        community.setDescription(description);

        MembershipProduct membershipProduct = new MembershipProduct();
        membershipProduct.setName(name);

        membershipService.basicMembershipProduct(membershipProduct);
        Community savedCommunity = communityRepository.save(community);
        return savedCommunity;
    }

    public void deleteCommunity(Long communityId) {
        Community community = communityRepository.findById(communityId)
                .orElseThrow(() -> new CommunityNotFoundException("Community not found"));
        communityRepository.delete(community);
    }

    public void banUser(Long user_id) {
        Ban ban = new Ban();
        ban.setUserId(user_id);
        // Save the Ban record in the repository
        banRepository.save(ban);
    }
    public void unbanUser(Long userId) {
        // Retrieve the Ban record for the given user ID
        Ban ban = banRepository.findByUserId(userId);
        banRepository.delete(ban);
    }

}
