package com.example.curltai.Model.Posts;

import com.example.curltai.Model.Community.Community;
import com.example.curltai.Model.Community.Media;
import com.example.curltai.Model.Users.Artist;
import com.example.curltai.Model.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_post;

    private String title;

    private String body;

    private Time created_at;

    private int likes;

    private Boolean members_only;

    @ManyToOne
    @JoinColumn(name="id_community")
    private Community community;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User author;

    @ManyToOne
    @JoinColumn(name="id_artist")
    private Artist artist;

    @JsonIgnore
    @OneToMany(mappedBy = "post")
    private Set<Media> media = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "post")
    private Set<Comment> comments = new HashSet<>();
}
