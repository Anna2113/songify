package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.SongDto;
import com.example.songify.domain.crud.exception.SongNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
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

    List<SongDtoWithoutArtists> findAllSongs() {
        return songRepository.findAll()
                .stream()
                .map(song -> new SongDtoWithoutArtists(
                        song.getId(),
                        song.getName()
                ))
                .collect(Collectors.toList());
    }

    SongDto findSongById(final Long songId) {
        return songRepository.findSongById(songId)
                .map(song -> SongDto.builder()
                        .id(song.getId())
                        .name(song.getName())
                        .artist(song.getArtist().getName())
                        .build())
                .orElseThrow(() -> new SongNotFoundException("Song with id: " + songId + " not found"));
    }

    void existsById(final Long id) {
        if(!songRepository.existsById(id)){
            throw new SongNotFoundException("Song with id: " + id + " not found");
        }
    }

}
