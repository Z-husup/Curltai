package com.example.curltai.Model.Community;

import com.example.curltai.Model.Store.MembershipProduct;
import com.example.curltai.Model.Users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "membership")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Membership{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_membership;

    private String expiring_date;

    @OneToOne
    @JoinColumn(name = "id_membership_product")
    private MembershipProduct membership_product;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;


    @OneToOne
    @JoinColumn(name = "community_id")
    private Community community;

}
