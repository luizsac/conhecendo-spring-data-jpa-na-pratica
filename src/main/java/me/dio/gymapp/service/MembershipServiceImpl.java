package me.dio.gymapp.service;

import lombok.AllArgsConstructor;
import me.dio.gymapp.entity.Membership;
import me.dio.gymapp.entity.dto.MembershipDTO;
import me.dio.gymapp.exception.MembershipNotFoundException;
import me.dio.gymapp.repository.MembershipRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MembershipServiceImpl implements MembershipService {

    private final MembershipRepository membershipRepository;
    private final MemberService memberService;

    @Override
    public Membership createMembership(MembershipDTO membershipDTO) {
        Membership membership = new Membership();
        membership.setMember(memberService.getMember(membershipDTO.getMemberId()));
        membership.setJoiningDate(LocalDateTime.now());
        return membershipRepository.save(membership);
    }

    @Override
    public Membership getMembership(Long id) {
        return membershipRepository.findById(id).orElseThrow(MembershipNotFoundException::new);
    }

    @Override
    public List<Membership> listMemberships() {
        return membershipRepository.findAll();
    }

    @Override
    public void deleteMembership(Long id) {
        Membership membership = getMembership(id);
        membershipRepository.delete(membership);
    }

}
