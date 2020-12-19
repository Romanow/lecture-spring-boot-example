package ru.digitalhabbits.spring.exceptions;

public class UserNotFoundException
        extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
