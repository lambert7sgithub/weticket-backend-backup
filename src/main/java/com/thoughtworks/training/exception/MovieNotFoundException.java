package com.thoughtworks.training.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException() {
        super("NOT FOUND THIS MOVIE");
    }
}
