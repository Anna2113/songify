package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.GenreDto;
import com.example.songify.domain.crud.exception.GenreNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
class GenreRetriever {
    private final GenreRepository genreRepository;

    Set<GenreDto> findAllGenres() {
        return genreRepository.findAll()
                .stream()
                .map(genre -> new GenreDto(
                        genre.getId(),
                        genre.getName()
                ))
                .collect(Collectors.toSet());
    }

    GenreDto findGenreById(final Long genreId) {
        return genreRepository.findById(genreId)
                .map(genre -> GenreDto.builder()
                        .id(genre.getId())
                        .name(genre.getName())
                        .build())
                .orElseThrow(() -> new GenreNotFoundException("Genre with id: " + genreId + " not found"));


    }

    void existsById(final Long id) {
        if(!genreRepository.existsById(id)){
            throw new GenreNotFoundException("Genre with id: " + id + " not found");
        }
    }
}
