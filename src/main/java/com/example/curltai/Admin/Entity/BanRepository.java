package com.example.curltai.Admin.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BanRepository extends JpaRepository<Ban, Long> {
    Ban findByUserId(Long userId);
}
