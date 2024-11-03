package com.example.songify.infrastructure.crud.genre;

import com.example.songify.domain.crud.dto.GenreDto;

import java.util.Set;

public record AllGenresDto(Set<GenreDto> genres) {
}
