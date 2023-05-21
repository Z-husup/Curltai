package com.example.curltai.Dto;

import lombok.Data;

@Data
public class NewCommentDto {
    String body;
    Long id_author;
    Long id_post;
}
