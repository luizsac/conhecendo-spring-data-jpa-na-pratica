package me.dio.gymapp.service;

import me.dio.gymapp.entity.Member;
import me.dio.gymapp.entity.dto.MemberDTO;
import me.dio.gymapp.entity.dto.UpdateMemberDTO;
import me.dio.gymapp.exception.MemberNotFoundException;

import java.util.List;

public interface MemberService {

    Member createMember(MemberDTO memberDTO);
    Member getMember(Long id) throws MemberNotFoundException;
    List<Member> listMembers();
    Member updateMember(UpdateMemberDTO updateMemberDTO, Long id);
    void deleteMember(Long id);

}
