package com.example.songify.infrastructure.crud.genre;

import com.example.songify.domain.crud.SongifyCrudFacade;
import com.example.songify.domain.crud.dto.GenreDto;
import com.example.songify.domain.crud.dto.GenreRequestDto;
import com.example.songify.infrastructure.crud.song.DeleteSongResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/genres")
class GenreController {

    private final SongifyCrudFacade songifyCrudFacade;

    @PostMapping("/{name}")
    ResponseEntity<GenreDto> postGenre(@RequestBody GenreRequestDto genreRequestDto){
        GenreDto genreDto = songifyCrudFacade.addGenre(genreRequestDto);
        return ResponseEntity.ok(genreDto);
    }

    @GetMapping
    ResponseEntity<AllGenresDto> getGenres(){
        Set<GenreDto> allGenres = songifyCrudFacade.findAllGenres();
        AllGenresDto genres = GenreControllerMapper.mapFromGenreToAllGenresDto(allGenres);
        return ResponseEntity.ok(genres);
    }

    @GetMapping("/{id}")
    ResponseEntity<GenreDto> getGenre(@PathVariable Long id){
        GenreDto genre = songifyCrudFacade.findGenreById(id);
        return ResponseEntity.ok(genre);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<DeleteGenreResponseDto> deleteGenre(@PathVariable Long id){
        songifyCrudFacade.deleteGenreById(id);
        DeleteGenreResponseDto body = GenreControllerMapper.mapFromGenreToDeleteGenreResponseDto(id);
        return ResponseEntity.ok(body);
    }

}
