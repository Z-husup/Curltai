package com.example.curltai.Dto;

import com.example.curltai.Model.Community.Media;
import com.example.curltai.Model.Community.Membership;
import lombok.Data;

import java.util.List;

@Data
public class MediaDto {

    List<Media> media;

    Membership membership;
}
