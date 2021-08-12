package ru.digitalhabbits.spring.user.web;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.digitalhabbits.spring.user.exceptions.EntityNotFoundException;
import ru.digitalhabbits.spring.user.model.ErrorResponse;

import static org.slf4j.LoggerFactory.getLogger;

@RestControllerAdvice
public class ExceptionController {
    private static final Logger logger = getLogger(ExceptionController.class);

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse notFound(EntityNotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse error(RuntimeException exception) {
        logger.error("", exception);
        return new ErrorResponse(exception.getMessage());
    }
}
