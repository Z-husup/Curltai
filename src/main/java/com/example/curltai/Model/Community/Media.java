package com.example.curltai.Model.Community;

import com.example.curltai.Model.Posts.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "media")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Media {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_media;

    private String link;

    @ManyToOne
    @JoinColumn(name="id_community")
    private Community community;

    @ManyToOne
    @JoinColumn(name="id_post")
    private Post post;
}