package com.example.songify.infrastructure.crud.album;

import com.example.songify.domain.crud.dto.AlbumDto;

import java.util.List;

public record AllAlbumsDto(List<AlbumDto> albums) {
}
