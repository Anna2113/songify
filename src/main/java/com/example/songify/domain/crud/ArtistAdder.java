package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.ArtistDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
class ArtistAdder {
    private final ArtistRepository artistRepository;

    ArtistDto addArtist(final String name) {
        Artist artist = saveArtist(name);
        return new ArtistDto(artist.getId(), artist.getName());
    }

    private Artist saveArtist(final String name) {
        Artist artist = new Artist(name);
        Artist artistToSave = artistRepository.save(artist);
        return artistToSave;
    }
}
