package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.ArtistDto;
import com.example.songify.domain.crud.dto.SongDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
class ArtistUpdater {

    private final ArtistRetriever artistRetriever;
    private final ArtistRepository artistRepository;

    ArtistDto updateArtistNameById(final Long artistId, final String name) {
        Artist artist = artistRetriever.findById(artistId);
        artistRepository.updateNameById(name, artistId);
        return new ArtistDto(artist.getId(), artist.getName());
    }
}
