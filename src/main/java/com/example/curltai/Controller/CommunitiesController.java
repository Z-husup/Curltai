package com.example.curltai.Controller;

import com.example.curltai.Dto.HomepageDto;
import com.example.curltai.Dto.SubCommunityDto;
import com.example.curltai.Model.Users.User;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Repository.UserRepository;
import com.example.curltai.Service.CommunityService;
import com.example.curltai.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CommunitiesController {

    private final CommunityRepository communityRepository;
    private final CommunityService commentService;
    private final UserService userService;
    private final UserRepository userRepository;

    public CommunitiesController(CommunityRepository communityRepository, CommunityService commentService,
                                 UserService userService, UserRepository userRepository) {
        this.communityRepository = communityRepository;
        this.commentService = commentService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/communities")
    public ResponseEntity getHomepageDto(@PathVariable User user) {
        HomepageDto homepageDto = new HomepageDto();
        // Получение списка всех сообществ
        homepageDto.setCommunities(communityRepository.findAll());
        // Получение подписок пользователя на сообщества
        homepageDto.setSubs((List) user.getCommunity());
        // Установка информации о пользователе
        homepageDto.setUser(user);
        // Возвращение объекта homepageDto в теле ответа с статусом 200 OK
        return ResponseEntity.ok(homepageDto);
    }

    @PostMapping("/communities")
    public ResponseEntity openNewCommunity(@PathVariable SubCommunityDto subCommunityDto) {
        userService.setSubCommunity(subCommunityDto);
        return ResponseEntity.ok(subCommunityDto);
    }

}
