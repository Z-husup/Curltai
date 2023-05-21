package com.example.curltai.Dto;

import com.example.curltai.Model.Community.Community;
import com.example.curltai.Model.Users.User;
import lombok.Data;

import java.util.List;

@Data
public class HomepageDto {
    List<Community> communities;
    List<Community> subs;
    User user;
}
