package com.example.curltai.Service;

import com.example.curltai.Interface.MembershipServiceInterface;
import com.example.curltai.Model.Store.MembershipProduct;
import com.example.curltai.Repository.MembershipProductRepository;
import org.springframework.stereotype.Service;

@Service
public class MembershipService implements MembershipServiceInterface {

    private final MembershipProductRepository membershipProductRepository;

    public MembershipService(MembershipProductRepository membershipProductRepository) {
        this.membershipProductRepository = membershipProductRepository;
    }

    public void basicMembershipProduct(MembershipProduct membershipProduct) {
        membershipProductRepository.save(membershipProduct);
    }
}
