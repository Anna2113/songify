package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.SongDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface SongRepository extends Repository<Song, Long> {
    Song save(Song song);

    @Query("SELECT s FROM Song s WHERE s.id = :id")
    Optional<Song> findById(Long id);

    List<Song> findAll();

    Optional<SongDto> findSongById(Long songId);
}
