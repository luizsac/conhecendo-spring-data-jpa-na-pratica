package me.dio.gymapp.exception;

import java.util.NoSuchElementException;

public class MembershipNotFoundException extends NoSuchElementException {

    private final String NAME = "Membership Not Found";

    public MembershipNotFoundException() {
        super("Membership with requested id was not found in the system");
    }

}
