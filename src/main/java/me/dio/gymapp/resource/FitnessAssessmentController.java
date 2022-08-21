package me.dio.gymapp.resource;

import me.dio.gymapp.entity.FitnessAssessment;
import me.dio.gymapp.entity.dto.FitnessAssessmentDTO;
import me.dio.gymapp.service.FitnessAssessmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fitness-assessments")
public class FitnessAssessmentController {

    private final FitnessAssessmentService fitnessAssessmentService;

    public FitnessAssessmentController(FitnessAssessmentService fitnessAssessmentService) {
        this.fitnessAssessmentService = fitnessAssessmentService;
    }

    @PostMapping
    public ResponseEntity<FitnessAssessment> createFitnessAssessment(@Valid @RequestBody FitnessAssessmentDTO fitnessAssessmentDTO) {
        FitnessAssessment createdFitnessAssessment = fitnessAssessmentService.createFitnessAssessment(fitnessAssessmentDTO);
        return new ResponseEntity<>(createdFitnessAssessment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FitnessAssessment> getFitnessAssessment(@PathVariable Long id) {
        FitnessAssessment fitnessAssessment = fitnessAssessmentService.getFitnessAssessment(id);
        return new ResponseEntity<>(fitnessAssessment, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FitnessAssessment>> listFitnessAssessments() {
        List<FitnessAssessment> fitnessAssessments = fitnessAssessmentService.listFitnessAssessments();
        return new ResponseEntity<>(fitnessAssessments, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFitnessAssessment(@PathVariable Long id) {
        fitnessAssessmentService.deleteFitnessAssessment(id);
        return ResponseEntity.ok().build();
    }

}
