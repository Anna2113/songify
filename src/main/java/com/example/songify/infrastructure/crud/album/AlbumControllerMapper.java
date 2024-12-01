package com.example.songify.infrastructure.crud.album;

import com.example.songify.domain.crud.dto.AlbumDto;

import java.util.List;

class AlbumControllerMapper {

    static AllAlbumsDto mapFromAlbumToAllAlbumsDto(final List<AlbumDto> allAlbums) {
        return new AllAlbumsDto(allAlbums);
    }
}
