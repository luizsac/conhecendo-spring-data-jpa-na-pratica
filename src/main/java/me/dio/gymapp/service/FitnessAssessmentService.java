package me.dio.gymapp.service;

import me.dio.gymapp.entity.FitnessAssessment;
import me.dio.gymapp.entity.dto.FitnessAssessmentDTO;

import java.util.List;

public interface FitnessAssessmentService {

    FitnessAssessment saveFitnessAssessment(FitnessAssessmentDTO fitnessAssessmentDTO);
    FitnessAssessment getFitnessAssessment(Long id);
    List<FitnessAssessment> listFitnessAssessments();
    FitnessAssessment deleteFitnessAssessement(Long id);

}
