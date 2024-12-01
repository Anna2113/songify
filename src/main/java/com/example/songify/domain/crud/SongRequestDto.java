package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.ArtistDto;
import com.example.songify.domain.crud.dto.ArtistDtoForSongAdder;
import com.example.songify.domain.crud.dto.SongLanguageDto;
import lombok.Builder;

import java.time.Instant;

@Builder
public record SongRequestDto(String name,
                             Instant releaseDate,
                             Long duration,
                             SongLanguageDto language) {
}
