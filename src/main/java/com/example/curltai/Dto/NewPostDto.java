package com.example.curltai.Dto;

import lombok.Data;

@Data
public class NewPostDto {

    Long id_user;

    Long id_community;

    String text;

    String image;
}
