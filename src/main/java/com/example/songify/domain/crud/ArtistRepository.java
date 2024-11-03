package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.ArtistDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.Set;

interface ArtistRepository extends Repository<Artist, Long> {

    Artist save(Artist artist);

    Optional<Artist> findById(Long artistId);

    Set<Artist> findAll();
}
