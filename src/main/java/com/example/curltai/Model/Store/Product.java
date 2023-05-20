package com.example.curltai.Model.Store;

import com.example.curltai.Model.Community.Community;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_product;

    private String name;

    private String description;

    private String image;

    private Integer price;

    @ManyToOne
    @JoinColumn(name="id_community")
    private Community community;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<Purchase> purchase = new HashSet<>();
}