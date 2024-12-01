package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.ArtistDto;
import com.example.songify.domain.crud.dto.ArtistDtoForSongAdder;
import com.example.songify.domain.crud.dto.SongDto;
import com.example.songify.domain.crud.dto.SongLanguageDto;
import com.example.songify.domain.crud.dto.SongRequestDtoWithArtist;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Log4j2
@AllArgsConstructor
class SongAdder {

    private final SongRepository songRepository;

    SongDto addSong(final SongRequestDtoWithArtist dto) {
        SongLanguageDto language = dto.language();
        SongLanguage songLanguage = SongLanguage.valueOf(language.name());

        ArtistDtoForSongAdder artistDto = new ArtistDtoForSongAdder(dto.artist().name());

        Artist artist = new Artist(artistDto.name());

        Song song = new Song(dto.name(), dto.releaseDate(), dto.duration(), songLanguage, artist);
        Song saveSong = songRepository.save(song);

        ArtistDtoForSongAdder newArtist = new ArtistDtoForSongAdder(artist.getName());

        return new SongDto(saveSong.getId(), saveSong.getName(), newArtist.name());
    }

    Song addSongAndGetEntity(final SongRequestDto dto) {
        SongLanguageDto language = dto.language();
        SongLanguage songLanguage = SongLanguage.valueOf(language.name());

        Song song = new Song(dto.name(), dto.releaseDate(), dto.duration(), songLanguage);
        return songRepository.save(song);
    }
}
