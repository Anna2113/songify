package com.example.songify.infrastructure.crud.artist;

import com.example.songify.domain.crud.dto.ArtistDto;

import java.util.Set;

class ArtistControllerMapper {

    static AllArtistsDto mapFromArtistToAllArtistsDto(final Set<ArtistDto> allArtists) {
        return new AllArtistsDto(allArtists);
    }
}
