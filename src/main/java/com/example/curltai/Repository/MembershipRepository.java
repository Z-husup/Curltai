package com.example.curltai.Repository;

import com.example.curltai.Model.Community.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
}
