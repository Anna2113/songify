package com.example.songify.infrastructure.crud.artist;

import org.springframework.http.HttpStatus;

public record DeleterArtistsResponseDto(String message, HttpStatus status) {
}
