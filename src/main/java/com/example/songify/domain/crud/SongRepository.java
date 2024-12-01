package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.SongDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

interface SongRepository extends Repository<Song, Long> {
    Song save(Song song);

    @Query("SELECT s FROM Song s WHERE s.id = :id")
    Optional<Song> findById(Long id);

    @Query("SELECT s FROM Song s")
    List<Song> findAll();

    @Query("SELECT s FROM Song s WHERE s.id = :songId")
    Optional<Song> findSongById(Long songId);

    boolean existsById(Long id);

    @Modifying
    @Query("DELETE FROM Song s WHERE s.id = :id")
    void deleteById(Long id);

    @Modifying
    @Query("UPDATE Song s SET s.name = :#{#newSong.name} WHERE s.id = :id")
    void updateById(Long id, Song newSong);
}
