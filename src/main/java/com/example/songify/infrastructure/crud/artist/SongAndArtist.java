package com.example.songify.infrastructure.crud.artist;

import com.example.songify.domain.crud.dto.ArtistDto;

import java.util.Set;

public record SongAndArtist(Set<ArtistDto> artistDto) {
}
