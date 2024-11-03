package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.GenreDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.Set;

interface GenreRepository extends Repository<Genre, Long> {

    Genre save(Genre genre);

    Set<Genre> findAll();

    Optional<Genre> findById(Long genreId);


}
