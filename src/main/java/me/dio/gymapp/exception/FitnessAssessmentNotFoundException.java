package me.dio.gymapp.exception;

import java.util.NoSuchElementException;

public class FitnessAssessmentNotFoundException extends NoSuchElementException {

    private final String NAME = "Fitness Assessment Not Found";

    public FitnessAssessmentNotFoundException() {
        super("Fitness Assessment with requested id was not found in the system");
    }

}
