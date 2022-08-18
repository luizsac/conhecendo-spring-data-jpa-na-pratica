package me.dio.gymapp.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFitnessAssessmentDTO {

    private final String notEmptyMessage = "This attribute is required.";

    @NotEmpty(message = notEmptyMessage)
    @Positive
    private double weight;

    @NotEmpty(message = notEmptyMessage)
    @Positive
    @DecimalMin(value = "1.00", message = "'${validatedValue}' has to be at least {value}.")
    private double height;

}
