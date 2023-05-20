package com.example.curltai.Model.Community;

import com.example.curltai.Model.Posts.Post;
import com.example.curltai.Model.Store.Product;
import com.example.curltai.Model.Store.Purchase;
import com.example.curltai.Model.Users.Artist;
import com.example.curltai.Model.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "community")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Community {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_community;

    private String name;

    private String description;

    private String image;

    private int members_number;

    @ManyToMany
    @JoinTable(
            name = "subscriptions",
            joinColumns = @JoinColumn(name = "id_community"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private Set<User> user = new HashSet<>();

    @OneToOne(mappedBy = "community")
    private Membership membership;

    @JsonIgnore
    @OneToMany(mappedBy = "community")
    private Set<Artist> artist = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "community")
    private Set<Post> post = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "community")
    private Set<Media> media = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "community")
    private Set<Product> product = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "community")
    private Set<Purchase> purchase = new HashSet<>();
}
