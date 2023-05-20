package com.example.curltai.Model.Users;

import com.example.curltai.Model.Community.Community;
import com.example.curltai.Model.Posts.Comment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artist")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_artist;

    private String login;

    private String password;

    private String bio;

    private String image;

    @ManyToOne
    @JoinColumn(name="id_community")
    private Community community;

    @JsonIgnore
    @OneToMany(mappedBy = "artist")
    private Set<Comment> comment = new HashSet<>();
}
