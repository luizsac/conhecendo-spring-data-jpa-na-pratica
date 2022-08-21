package me.dio.gymapp.exception;

import java.util.NoSuchElementException;

public class MemberNotFoundException extends NoSuchElementException {

    private final String NAME = "Member Not Found";

    public MemberNotFoundException() {
        super("Member with requested id was not found in the system");
    }

}
