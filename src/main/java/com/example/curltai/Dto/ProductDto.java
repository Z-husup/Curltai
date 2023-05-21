package com.example.curltai.Dto;

import com.example.curltai.Model.Community.Community;
import com.example.curltai.Model.Store.Purchase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ProductDto {

    private String name;

    private String description;

    private String image;

    private Integer price;

}
