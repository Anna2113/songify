package com.example.songify.domain.crud.dto;

import java.time.Instant;

public record SongRequestDtoWithArtist(String name,
                                       Instant releaseDate,
                                       Long duration,
                                       SongLanguageDto language,
                                       ArtistDto artist) {
}
