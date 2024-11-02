package com.example.songify.infrastructure.crud.artist;

import com.example.songify.domain.crud.SongifyCrudFacade;
import com.example.songify.domain.crud.dto.ArtistDto;
import com.example.songify.domain.crud.dto.ArtistRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/artists")
class ArtistController {

    private final SongifyCrudFacade songifyCrudFacade;

    @PostMapping("/{name}")
    ResponseEntity<ArtistDto> postArtist(@RequestBody ArtistRequestDto artistRequestDto){
        ArtistDto artistDto = songifyCrudFacade.addArtist(artistRequestDto);
        return ResponseEntity.ok(artistDto);
    }
}