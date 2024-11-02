package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.SongDto;
import com.example.songify.domain.crud.dto.SongLanguageDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
class SongAdder {

    private final SongRepository songRepository;

    SongDto addSong(final SongRequestDto dto) {
        SongLanguageDto language = dto.language();
        SongLanguage songLanguage = SongLanguage.valueOf(language.name());

        Song song = new Song(dto.name(), dto.releaseDate(), dto.duration(), songLanguage);
        Song saveSong = songRepository.save(song);
        return new SongDto(saveSong.getId(), saveSong.getName());
    }
}
