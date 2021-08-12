package ru.digitalhabbits.spring.user.exceptions;

public class EntityNotFoundException
        extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
