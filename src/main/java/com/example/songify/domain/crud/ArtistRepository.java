package com.example.songify.domain.crud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

interface ArtistRepository extends Repository<Artist, Long> {

    Artist save(Artist artist);

    Optional<Artist> findById(Long artistId);
}
