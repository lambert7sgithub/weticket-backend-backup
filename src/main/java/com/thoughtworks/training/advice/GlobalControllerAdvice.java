package com.thoughtworks.training.advice;

import com.thoughtworks.training.exception.MovieNotFoundException;
import com.thoughtworks.training.exception.RoleException;
import com.thoughtworks.training.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({MovieNotFoundException.class})
    public ErrorResponse handleNotFountException(Exception exception) {
        return new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value() + "");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserException.class})
    public ErrorResponse handleUserNotFountException(Exception exception) {
        return new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value() + "");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({RoleException.class})
    public ErrorResponse handleRoleNotFountException(Exception exception) {
        return new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value() + "");
    }
}
