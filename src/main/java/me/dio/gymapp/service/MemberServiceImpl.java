package me.dio.gymapp.service;

import lombok.AllArgsConstructor;
import me.dio.gymapp.entity.Member;
import me.dio.gymapp.entity.dto.MemberDTO;
import me.dio.gymapp.entity.dto.UpdateMemberDTO;
import me.dio.gymapp.entity.dto.mapper.MemberMapper;
import me.dio.gymapp.exception.MemberNotFoundException;
import me.dio.gymapp.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public Member createMember(MemberDTO memberDTO) {
        Member member = memberMapper.toModel(memberDTO);
        return memberRepository.save(member);
    }

    @Override
    public Member getMember(Long id) throws MemberNotFoundException {
        return memberRepository.findById(id).orElseThrow(MemberNotFoundException::new);
    }

    @Override
    public List<Member> listMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member updateMember(UpdateMemberDTO updateMemberDTO, Long id) {
        Member member = getMember(id);
        member.setName(updateMemberDTO.getName());
        member.setNeighborhood(updateMemberDTO.getNeighborhood());
        member.setBirthDate(updateMemberDTO.getBirthDate());
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Long id) {
        Member member = getMember(id);
        memberRepository.delete(member);
    }

}
