package com.example.curltai.Repository;

import com.example.curltai.Model.Store.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
