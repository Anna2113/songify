package com.example.songify.domain.crud;

import com.example.songify.domain.crud.exception.AlbumNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
class AlbumRetriever {
    private final AlbumRepository albumRepository;

    Album findById(final Long albumId) {
        return albumRepository.findById(albumId)
                .orElseThrow(() -> new AlbumNotFoundException("Album with id: " + albumId + " not found"));
    }
}
