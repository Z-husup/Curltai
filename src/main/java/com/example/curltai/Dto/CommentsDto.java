package com.example.curltai.Dto;

import com.example.curltai.Model.Posts.Comment;
import lombok.Data;

import java.util.List;

@Data
public class CommentsDto {

    List<Comment> comments;

}
