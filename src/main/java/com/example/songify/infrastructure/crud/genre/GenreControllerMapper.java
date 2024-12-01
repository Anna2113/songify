package com.example.songify.infrastructure.crud.genre;

import com.example.songify.domain.crud.dto.GenreDto;
import org.springframework.http.HttpStatus;

import java.util.Set;

class GenreControllerMapper {

    static AllGenresDto mapFromGenreToAllGenresDto(final Set<GenreDto> allGenres) {
        return new AllGenresDto(allGenres);
    }

     static DeleteGenreResponseDto mapFromGenreToDeleteGenreResponseDto(final Long id) {
        return new DeleteGenreResponseDto("You deleted genre with id: " + id, HttpStatus.OK);
    }
}
