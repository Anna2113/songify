package com.example.songify.infrastructure.crud.song;

import com.example.songify.domain.crud.SongDtoWithoutArtists;
import com.example.songify.domain.crud.dto.SongDto;

import java.util.List;

public record AllSongsDto(List<SongDtoWithoutArtists> songs) {
}
