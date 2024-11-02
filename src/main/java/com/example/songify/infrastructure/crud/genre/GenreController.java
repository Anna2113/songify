package com.example.songify.infrastructure.crud.genre;

import com.example.songify.domain.crud.SongifyCrudFacade;
import com.example.songify.domain.crud.dto.GenreDto;
import com.example.songify.domain.crud.dto.GenreRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}