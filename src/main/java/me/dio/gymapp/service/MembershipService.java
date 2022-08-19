package me.dio.gymapp.service;

import me.dio.gymapp.entity.Member;
import me.dio.gymapp.entity.Membership;
import me.dio.gymapp.entity.dto.MembershipDTO;

import java.util.List;

public interface MembershipService {

    Membership saveMembership(MembershipDTO membershipDTO);
    Member getMember(Long id);
    List<Member> listMembers();
    Member deleteMember(Long id);

}
