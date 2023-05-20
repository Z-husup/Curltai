package com.example.curltai.Dto;

import com.example.curltai.Model.Community.Membership;
import com.example.curltai.Model.Posts.Post;
import com.example.curltai.Model.Users.Artist;
import lombok.Data;

import java.util.List;

@Data
public class CommunityDto {
    List<Post> posts;
    List<Artist> artists;
    String image;
    Membership membership;
}
