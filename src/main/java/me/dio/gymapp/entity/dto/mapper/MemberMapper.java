package me.dio.gymapp.entity.dto.mapper;

import me.dio.gymapp.entity.Member;
import me.dio.gymapp.entity.dto.MemberDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member toModel(MemberDTO memberDTO);

    MemberDTO toDTO(Member member);

}
