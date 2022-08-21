package me.dio.gymapp.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembershipDTO {

    @NotNull
    @Positive(message = "The member ID must be a positive number.")
    private Long memberId;
}
