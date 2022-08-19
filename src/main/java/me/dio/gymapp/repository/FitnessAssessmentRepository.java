package me.dio.gymapp.repository;

import me.dio.gymapp.entity.FitnessAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FitnessAssessmentRepository extends JpaRepository<FitnessAssessment, Long> {
}
