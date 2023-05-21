package com.example.curltai.Model.Users;

import com.example.curltai.Model.Community.Community;
import com.example.curltai.Model.Community.Membership;
import com.example.curltai.Model.Posts.Comment;
import com.example.curltai.Model.Posts.Post;
import com.example.curltai.Model.Store.Purchase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_user;

    private String login;

    private String email;

    private String password;

    @JsonIgnore
    @ManyToMany(mappedBy = "user")
    private Set<Community> community = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Membership> membership = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Purchase> purchase = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Comment> comment = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private Set<Post> post = new HashSet<>();


    public User(Long id_user, String login, String email, String password) {
        this.id_user = id_user;
        this.login = login;
        this.email = email;
        this.password = password;
    }

}
