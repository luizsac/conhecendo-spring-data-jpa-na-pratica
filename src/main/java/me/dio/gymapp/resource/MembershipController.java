package me.dio.gymapp.resource;

import lombok.AllArgsConstructor;
import me.dio.gymapp.entity.Membership;
import me.dio.gymapp.entity.dto.MembershipDTO;
import me.dio.gymapp.service.MembershipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/membership")
public class MembershipController {

    private final MembershipService membershipService;

    @PostMapping
    public ResponseEntity<Membership> createMembership(@Valid @RequestBody MembershipDTO membershipDTO) {
        Membership createdMembership = membershipService.createMembership(membershipDTO);
        return new ResponseEntity<>(createdMembership, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membership> getMembership(@PathVariable Long id) {
        Membership membership = membershipService.getMembership(id);
        return new ResponseEntity<>(membership, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Membership>> listMemberships() {
        List<Membership> memberships = membershipService.listMemberships();
        return new ResponseEntity<>(memberships, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMembership(@PathVariable Long id) {
        membershipService.deleteMembership(id);
        return ResponseEntity.ok().build();
    }

}
