package com.example.curltai.Dto;

import com.example.curltai.Model.Community.Media;
import com.example.curltai.Model.Community.Membership;
import com.example.curltai.Model.Store.Product;
import lombok.Data;

import java.util.List;
@Data
public class StoreDto {
    List<Product> products;
    Membership membership;
}
