package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.GenreDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
class GenreAdder {

    private final GenreRepository genreRepository;

    GenreDto addGenre(final String name) {
        Genre genre = new Genre(name);
        Genre savedGenre = genreRepository.save(genre);
        return new GenreDto(savedGenre.getId(), savedGenre.getName());
    }
}
