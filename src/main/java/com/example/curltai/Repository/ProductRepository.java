package com.example.curltai.Repository;

import com.example.curltai.Model.Store.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
