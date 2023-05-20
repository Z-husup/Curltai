package com.example.curltai.Model.Store;

import com.example.curltai.Model.Community.Community;
import com.example.curltai.Model.Community.Membership;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "membership_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembershipProduct {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_membership_product;

    private String name;

    private String description;

    private String image;

    private String expiringDate;

    private Integer price;

    @OneToOne(mappedBy = "membership_product")
    private Membership membership;

    @ManyToOne
    @JoinColumn(name="id_community")
    private Community community;
}
