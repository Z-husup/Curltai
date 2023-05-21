package com.example.curltai.Controller;

import com.example.curltai.Dto.MediaDto;
import com.example.curltai.Dto.ProductDto;
import com.example.curltai.Dto.StoreDto;
import com.example.curltai.Model.Store.Product;
import com.example.curltai.Repository.CommunityRepository;
import com.example.curltai.Service.MediaService;
import com.example.curltai.Service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class StoreController {

    private final CommunityRepository communityRepository;
    private final StoreService storeService;

    public StoreController(CommunityRepository communityRepository, StoreService storeService) {
        this.communityRepository = communityRepository;
        this.storeService = storeService;
    }

    @GetMapping("/{community_id}/store")
    public ResponseEntity getStoreDto(@PathVariable Long community_id) {
        StoreDto storeDto = storeService.getStoreDto(community_id);
        return ResponseEntity.ok(storeDto);
    }

    @GetMapping("/{community_id}/store/{product_id}")
    public ResponseEntity getProduct(@PathVariable Long product_id) {
        Product product = storeService.getProduct(product_id);
        return ResponseEntity.ok(product);
    }
}
