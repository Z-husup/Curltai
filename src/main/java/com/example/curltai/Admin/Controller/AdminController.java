package com.example.curltai.Admin.Controller;

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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
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
    public ModelAndView showAdminPage() {
        ModelAndView modelAndView = new ModelAndView("admin");
        List<Community> communities = communityService.getAllCommunities();
        modelAndView.addObject("communities", communities);
        return modelAndView;
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



    @PostMapping(value = "/new-community", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Community> createNewCommunity(@RequestBody MultiValueMap<String, String> formData) {
        String communityName = formData.getFirst("name");
        String communityImage = formData.getFirst("image");
        String communityDescription = formData.getFirst("description");

        NewCommunityDto newCommunityDto = new NewCommunityDto();
        newCommunityDto.setName(communityName);
        newCommunityDto.setImage(communityImage);
        newCommunityDto.setDescription(communityDescription);

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
