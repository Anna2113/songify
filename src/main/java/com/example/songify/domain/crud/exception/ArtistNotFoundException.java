package com.example.songify.domain.crud.exception;

public class ArtistNotFoundException extends RuntimeException {
    public ArtistNotFoundException(final String message) {
        super("Artist with id: " + message + " not found");
    }
}
