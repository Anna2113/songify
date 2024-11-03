package com.example.songify.domain.crud;

import com.example.songify.domain.crud.exception.ArtistNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
class ArtistRetriever {
    private final ArtistRepository artistRepository;

    Artist findById(final Long artistId) {
        return artistRepository.findById(artistId)
                .orElseThrow(() -> new ArtistNotFoundException(artistId.toString()));
    }
}
