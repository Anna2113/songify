package com.example.songify.domain.crud.dto;

import java.util.Set;

public record AlbumWithSongsDto(
        AlbumDto albumDto,
        Set<SongDto> songs
) {
}
