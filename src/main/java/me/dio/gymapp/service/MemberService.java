package me.dio.gymapp.service;

import me.dio.gymapp.entity.Member;
import me.dio.gymapp.entity.dto.MemberDTO;
import me.dio.gymapp.entity.dto.UpdateMemberDTO;

import java.util.List;

public interface MemberService {

    Member saveMember(MemberDTO memberDTO);
    Member getMember(Long id);
    List<Member> listMembers();
    Member updateMember(UpdateMemberDTO updateMemberDTO);
    Member deleteMember(Long id);

}
