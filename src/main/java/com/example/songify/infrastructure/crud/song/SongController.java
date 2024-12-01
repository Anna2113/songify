package com.example.songify.infrastructure.crud.song;

import com.example.songify.domain.crud.SongDtoWithoutArtists;
import com.example.songify.domain.crud.SongRequestDto;
import com.example.songify.domain.crud.SongifyCrudFacade;
import com.example.songify.domain.crud.dto.SongDto;
import com.example.songify.domain.crud.dto.SongRequestDtoWithArtist;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    ResponseEntity<SongDto> postSong(@RequestBody SongRequestDtoWithArtist songRequestDtoWithArtist){
        SongDto songDto = songifyCrudFacade.addSong(songRequestDtoWithArtist);
        return ResponseEntity.ok(songDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateSongResponseDto> update(@PathVariable Long id, @RequestBody @Valid UpdateSongRequestDto request){
        SongDtoWithoutArtists newSong = SongControllerMapper.mapFromUpdateSongRequestDtoToSong(id, request);
        songifyCrudFacade.updateSongById(id, newSong);
        UpdateSongResponseDto response = SongControllerMapper.mapFromSongToUpdateSongResponseDto(newSong);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    ResponseEntity<AllSongsDto> getSongs(){
        List<SongDtoWithoutArtists> allSongs = songifyCrudFacade.findAllSongs();
        AllSongsDto songs = SongControllerMapper.mapFromSongToAllSongsDto(allSongs);
        return ResponseEntity.ok(songs);
    }


    @GetMapping("/{id}")
    ResponseEntity<SongDto> getSong(@PathVariable Long id){
        SongDto song = songifyCrudFacade.findSongById(id);
        return ResponseEntity.ok(song);
    }

    @DeleteMapping("/delete/song/{id}")
    ResponseEntity<DeleteSongResponseDto> deleteSong(@PathVariable Long id){
        songifyCrudFacade.deleteSongById(id);
        DeleteSongResponseDto body = SongControllerMapper.mapFromSongToDeleteSongResponseDto(id);
        return ResponseEntity.ok(body);
    }

}
