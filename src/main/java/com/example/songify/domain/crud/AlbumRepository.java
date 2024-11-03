package com.example.songify.domain.crud;

import org.springframework.data.repository.Repository;

import java.util.Optional;

interface AlbumRepository extends Repository<Album, Long> {
    Album save(Album album);

    Optional<Album> findById(Long albumId);
}
