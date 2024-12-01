package com.example.songify.domain.crud.dto;

import com.example.songify.domain.crud.SongDtoWithoutArtists;

import java.util.Set;

public record AlbumWithSongsDto(
        AlbumDto albumDto,
        Set<SongDtoWithoutArtists> songs
) {
}
