package com.example.curltai.Model.Posts;

import com.example.curltai.Model.Users.Artist;
import com.example.curltai.Model.Users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Entity
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_comment;

    private String body;

    private int likes;

    private Time created_at;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name="id_artist")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name="id_post")
    private Post post;
}
