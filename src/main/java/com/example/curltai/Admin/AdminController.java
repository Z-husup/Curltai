package com.example.curltai.Admin;

import com.example.curltai.Admin.Dto.NewArtistDto;
import com.example.curltai.Admin.Dto.NewCommunityDto;
import com.example.curltai.Admin.Service.AdminService;
import com.example.curltai.Model.Community.Community;
import com.example.curltai.Model.Users.User;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Service.CommunityService;
import com.example.curltai.Service.MembershipService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final CommunityRepository communityRepository;
    private final CommunityService communityService;
    private final MembershipService membershipService;
    private final AdminService adminService;
    public AdminController(CommunityRepository communityRepository, CommunityService communityService, MembershipService membershipService, AdminService adminService) {
        this.communityRepository = communityRepository;
        this.communityService = communityService;
        this.membershipService = membershipService;
        this.adminService = adminService;
    }

    @GetMapping
    public ResponseEntity<List<Community>> showAdminPage() {
        List<Community> communities = communityService.getAllCommunities();
        return ResponseEntity.ok().body(communities);
    }

    @GetMapping("/new-community")
    public ResponseEntity<Resource> showNewCommunityPage() throws IOException {
        Resource resource = new ClassPathResource("static/admin/new-community.html");
        return ResponseEntity.ok().body(resource);
    }

    @GetMapping("/{community_id}/community")
    public ModelAndView showCommunityPage(@PathVariable("community_id") Long communityId) {
        ModelAndView modelAndView = new ModelAndView("community");
        Community community = communityService.getCommunityById(communityId);
        modelAndView.addObject("community", community);
        return modelAndView;
    }


    @PostMapping(value = "/new-community")
    public ResponseEntity<Community> createNewCommunity(@RequestBody NewCommunityDto newCommunityDto) {
        Community createdCommunity = adminService.createCommunity(newCommunityDto);
        return ResponseEntity.ok().body(createdCommunity);
    }


    @PostMapping("/{community_id}/community")
    public ResponseEntity createNewArtist(@PathVariable Long community_id, @RequestBody NewArtistDto newArtistDto){
        String name = newArtistDto.getUsername();
        String image = newArtistDto.getImage();
        String bio = newArtistDto.getBio();
        return ResponseEntity.ok(newArtistDto);
    }

    @DeleteMapping("/{community_id}/community")
    public ResponseEntity<Void> deleteCommunity(@PathVariable("community_id") Long communityId) {
        adminService.deleteCommunity(communityId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/ban")
    public ResponseEntity<Void> banUser( @RequestBody User user){
        adminService.banUser(user.getId_user());
        return ResponseEntity.ok().build();
    }


}
