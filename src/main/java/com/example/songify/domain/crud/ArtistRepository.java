package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.ArtistDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

interface ArtistRepository extends Repository<Artist, Long> {

    Artist save(Artist artist);

    Optional<Artist> findById(Long artistId);

    Set<Artist> findAll();

    boolean existsById(Long id);

    @Modifying
    @Query("DELETE FROM Artist a WHERE a.id = :id")
    int deleteById(Long id);

    @Modifying
    @Query("UPDATE Artist a SET a.name = :name WHERE a.id = :id")
    void updateNameById(@Param("name") String name, @Param("id") Long id);
}
