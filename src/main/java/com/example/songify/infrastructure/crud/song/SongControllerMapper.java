package com.example.songify.infrastructure.crud.song;

import com.example.songify.domain.crud.SongDtoWithoutArtists;
import com.example.songify.domain.crud.dto.SongDto;
import org.springframework.http.HttpStatus;

import java.util.List;

class SongControllerMapper {

    static SongDtoWithoutArtists mapFromUpdateSongRequestDtoToSong(final Long id, final UpdateSongRequestDto request) {
        return new SongDtoWithoutArtists(id, request.songName());
    }

    static UpdateSongResponseDto mapFromSongToUpdateSongResponseDto(final SongDtoWithoutArtists newSong) {
        return new UpdateSongResponseDto(newSong.name());
    }

    static AllSongsDto mapFromSongToAllSongsDto(final List<SongDtoWithoutArtists> allSongs) {
        return new AllSongsDto(allSongs);
    }

    static DeleteSongResponseDto mapFromSongToDeleteSongResponseDto(final Long id) {
        return new DeleteSongResponseDto("You deleted song with id: " + id, HttpStatus.OK);
    }
}
