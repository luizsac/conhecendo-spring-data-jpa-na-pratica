package me.dio.gymapp.service;

import me.dio.gymapp.entity.Membership;
import me.dio.gymapp.entity.dto.MembershipDTO;

import java.util.List;

public interface MembershipService {

    Membership createMembership(MembershipDTO membershipDTO);
    Membership getMembership(Long id);
    List<Membership> listMemberships();
    void deleteMembership(Long id);

}
