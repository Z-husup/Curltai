package com.example.curltai.Service;

import com.example.curltai.Dto.ProductDto;
import com.example.curltai.Dto.StoreDto;
import com.example.curltai.Model.Community.Community;
import com.example.curltai.Model.Store.Product;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StoreService {

    private final CommunityRepository communityRepository;
    private final ProductRepository productRepository;

    public StoreService(CommunityRepository communityRepository, ProductRepository productRepository) {
        this.communityRepository = communityRepository;
        this.productRepository = productRepository;
    }


    public StoreDto getStoreDto(Long communityId) {
        Community community = communityRepository.findById(communityId).orElseThrow();
        StoreDto storeDto = new StoreDto();
        storeDto.setProducts(new ArrayList<>(community.getProduct()));
        storeDto.setMembership(community.getMembership());
        return storeDto;
    }

    public Product getProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        return product;
    }
}
