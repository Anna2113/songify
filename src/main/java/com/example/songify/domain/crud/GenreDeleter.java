package com.example.songify.domain.crud;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@AllArgsConstructor
@Transactional
class GenreDeleter {

    private final GenreRepository genreRepository;

    void deleteById(final Long id) {
        genreRepository.deleteById(id);
    }
}
