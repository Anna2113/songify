package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.AlbumDto;
import com.example.songify.domain.crud.dto.SongDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

interface AlbumRepository extends Repository<Album, Long> {
    Album save(Album album);

    Optional<Album> findById(Long albumId);

    List<Album> findAll();

    Optional<AlbumDto> findAlbumById(Long albumId);

    @Query(""" 
            SELECT a FROM Album a
            INNER JOIN FETCH a.songs songs
            WHERE a.id = :id""")
    Optional<Album> findAllSongsByAlbumId(Long id);
}
