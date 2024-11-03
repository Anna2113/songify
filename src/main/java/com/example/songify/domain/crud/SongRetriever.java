package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.AlbumDto;
import com.example.songify.domain.crud.dto.AlbumWithSongsDto;
import com.example.songify.domain.crud.dto.SongDto;
import com.example.songify.domain.crud.exception.AlbumNotFoundException;
import com.example.songify.domain.crud.exception.SongNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
class SongRetriever {
    private final SongRepository songRepository;

    Song findById(Long id){
        return songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException("Song with id: " + id + " not found"));
    }

    List<SongDto> findAllSongs() {
        return songRepository.findAll()
                .stream()
                .map(song -> new SongDto(
                        song.getId(),
                        song.getName()
                ))
                .collect(Collectors.toList());
    }

    SongDto findSongById(final Long songId) {
        return songRepository.findSongById(songId)
                .map(song -> SongDto.builder()
                        .id(song.id())
                        .name(song.name())
                        .build())
                .orElseThrow(() -> new SongNotFoundException("Song with id: " + songId + " not found"));
    }

}
