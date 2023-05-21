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
        // Получение списка всех сообществ
        homepageDto.setCommunities(communityRepository.findAll());
        // Получение подписок пользователя на сообщества
        homepageDto.setSubs((List) user.getCommunity());
        // Установка информации о пользователе
        homepageDto.setUser(user);
        // Возвращение объекта homepageDto в теле ответа с статусом 200 OK
        return ResponseEntity.ok(homepageDto);
    }

}
