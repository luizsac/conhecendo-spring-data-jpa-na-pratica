package me.dio.gymapp.service;

import lombok.AllArgsConstructor;
import me.dio.gymapp.entity.FitnessAssessment;
import me.dio.gymapp.entity.dto.FitnessAssessmentDTO;
import me.dio.gymapp.exception.FitnessAssessmentNotFoundException;
import me.dio.gymapp.repository.FitnessAssessmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FitnessAssessmentServiceImpl implements FitnessAssessmentService {

    private final FitnessAssessmentRepository fitnessAssessmentRepository;
    private final MemberService memberService;

    @Override
    public FitnessAssessment createFitnessAssessment(FitnessAssessmentDTO fitnessAssessmentDTO) {
        FitnessAssessment fitnessAssessment = new FitnessAssessment();
        fitnessAssessment.setMember(memberService.getMember(fitnessAssessmentDTO.getMemberId()));
        fitnessAssessment.setWeight(fitnessAssessmentDTO.getWeight());
        fitnessAssessment.setHeight(fitnessAssessmentDTO.getHeight());
        fitnessAssessment.setAssessmentDate(LocalDateTime.now());
        return fitnessAssessmentRepository.save(fitnessAssessment);
    }

    @Override
    public FitnessAssessment getFitnessAssessment(Long id) {
        return fitnessAssessmentRepository.findById(id).orElseThrow(FitnessAssessmentNotFoundException::new);
    }

    @Override
    public List<FitnessAssessment> listFitnessAssessments() {
        return fitnessAssessmentRepository.findAll();
    }

    @Override
    public void deleteFitnessAssessment(Long id) {
        FitnessAssessment fitnessAssessment = getFitnessAssessment(id);
        fitnessAssessmentRepository.delete(fitnessAssessment);
    }
    
}
