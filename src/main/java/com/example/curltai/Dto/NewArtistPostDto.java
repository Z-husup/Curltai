package com.example.curltai.Dto;

import lombok.Data;

@Data
public class NewArtistPostDto {

    Long id_artist;

    Long id_community;

    String text;

    String image;

    Boolean members_only;

}
