package me.dio.gymapp.resource;


import lombok.AllArgsConstructor;
import me.dio.gymapp.entity.Member;
import me.dio.gymapp.entity.dto.MemberDTO;
import me.dio.gymapp.entity.dto.UpdateMemberDTO;
import me.dio.gymapp.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> createMember(@Valid @RequestBody MemberDTO memberDTO) {
        Member createdMember = memberService.createMember(memberDTO);
        return new ResponseEntity<>(createdMember, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id) {
        Member member = memberService.getMember(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Member>> listMembers() {
        List<Member> members = memberService.listMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@Valid @RequestBody UpdateMemberDTO updateMemberDTO, @PathVariable Long id) {
        Member updatedMember = memberService.updateMember(updateMemberDTO, id);
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok().build();
    }

}
