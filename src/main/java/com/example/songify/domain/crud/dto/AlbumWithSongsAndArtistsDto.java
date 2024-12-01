package com.example.songify.domain.crud.dto;

import java.util.Set;

public record AlbumWithSongsAndArtistsDto(
        AlbumDto albumId,
        Set<SongDto> songs
) {
}
