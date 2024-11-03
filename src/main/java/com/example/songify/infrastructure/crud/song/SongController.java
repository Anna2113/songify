package com.example.songify.infrastructure.crud.song;

import com.example.songify.domain.crud.SongRequestDto;
import com.example.songify.domain.crud.SongifyCrudFacade;
import com.example.songify.domain.crud.dto.SongDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/songs")
class SongController {

    private final SongifyCrudFacade songifyCrudFacade;

    @PostMapping()
    ResponseEntity<SongDto> postSong(@RequestBody SongRequestDto songRequestDto){
        SongDto songDto = songifyCrudFacade.addSong(songRequestDto);
        return ResponseEntity.ok(songDto);
    }

    @GetMapping
    ResponseEntity<AllSongsDto> getSongs(){
        List<SongDto> allSongs = songifyCrudFacade.findAllSongs();
        AllSongsDto songs = new AllSongsDto(allSongs);
        return ResponseEntity.ok(songs);
    }

    @GetMapping("/{id}")
    ResponseEntity<SongDto> getSong(@PathVariable Long id){
        SongDto song = songifyCrudFacade.findSongById(id);
        return ResponseEntity.ok(song);
    }
}
