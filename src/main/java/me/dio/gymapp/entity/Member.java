package me.dio.gymapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "members")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String cpf;

    private String neighborhood;

    private LocalDate birthDate;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<FitnessAssessment> fitnessAssessment = new ArrayList<>();

    public void setFitnessAssessment(List<FitnessAssessment> fitnessAssessment) {
        this.fitnessAssessment = fitnessAssessment;
    }

    public List<FitnessAssessment> getFitnessAssessment() {
        return fitnessAssessment;
    }

}
