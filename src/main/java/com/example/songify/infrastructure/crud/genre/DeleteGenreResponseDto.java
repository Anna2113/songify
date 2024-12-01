package com.example.songify.infrastructure.crud.genre;

import org.springframework.http.HttpStatus;

public record DeleteGenreResponseDto(String message, HttpStatus status) {
}
