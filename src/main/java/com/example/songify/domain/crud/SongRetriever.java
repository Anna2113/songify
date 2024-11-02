package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.SongDto;
import com.example.songify.domain.crud.exception.SongNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
class SongRetriever {

    private final SongRepository songRepository;

    Song findSongById(Long id){
        return songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException("Song with id: " + id + " not found"));
    }
}
