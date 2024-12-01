package com.example.songify.domain.crud.dto;

import java.util.Set;

public record AlbumWithArtistsDto(Set<ArtistDto> artists) {
}
