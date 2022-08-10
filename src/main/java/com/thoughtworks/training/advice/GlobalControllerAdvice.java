package com.thoughtworks.training.advice;

import com.thoughtworks.training.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
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

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({BadCredentialsException.class})
    public ErrorResponse handleLoginFountException() {
        return new ErrorResponse("Username or password is wrong", HttpStatus.NOT_FOUND.value() + "");
    }
}
