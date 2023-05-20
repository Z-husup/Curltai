package com.example.curltai.Model.Store;

import com.example.curltai.Model.Community.Community;
import com.example.curltai.Model.Users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchase")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_purchase;

    private String shipment;

    @ManyToOne
    @JoinColumn(name="id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name="id_community")
    private Community community;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;
}