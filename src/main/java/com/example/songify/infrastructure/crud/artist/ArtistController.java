package com.example.songify.infrastructure.crud.artist;

import com.example.songify.domain.crud.SongifyCrudFacade;
import com.example.songify.domain.crud.dto.ArtistDto;
import com.example.songify.domain.crud.dto.ArtistRequestDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/artists")
class ArtistController {

    private final SongifyCrudFacade songifyCrudFacade;

    @PostMapping("/{name}")
    ResponseEntity<ArtistDto> postArtist(@RequestBody ArtistRequestDto artistRequestDto) {
        ArtistDto artistDto = songifyCrudFacade.addArtist(artistRequestDto);
        return ResponseEntity.ok(artistDto);
    }

//    @PutMapping("/{artistId}/{albumId}")
//    ResponseEntity<String> addArtistToAlbum(@PathVariable Long artistId, @PathVariable Long albumId){
//        songifyCrudFacade.addArtistToAlbum(artistId, albumId);
//        return ResponseEntity.ok("Assigned artist to album");
//    }

    @PostMapping("/defaultAlbum/defaultSong")
    ResponseEntity<ArtistDto> addArtistWithDefaultAlbumAndSong(@RequestBody ArtistRequestDto artistRequestDto) {
        ArtistDto artistDto = songifyCrudFacade.addArtistWithDefaultAlbumAndSong(artistRequestDto);
        return ResponseEntity.ok(artistDto);
    }

    @PatchMapping("/{id}")
    ResponseEntity<ArtistDto> updateArtistNameById(@PathVariable Long id, @Valid @RequestBody ArtistUpdateRequestDto artistRequestDto) {
        ArtistDto newArtist = songifyCrudFacade.updateArtistNameById(id, artistRequestDto.newArtistName());
        return ResponseEntity.ok(newArtist);
    }

    @GetMapping()
    ResponseEntity<AllArtistsDto> getArtists() {
        Set<ArtistDto> allArtists = songifyCrudFacade.findAllArtists();
        AllArtistsDto artists = ArtistControllerMapper.mapFromArtistToAllArtistsDto(allArtists);
        return ResponseEntity.ok(artists);
    }

    @GetMapping("/{id}")
    ResponseEntity<ArtistDto> getArtist(@PathVariable Long id) {
        ArtistDto artist = songifyCrudFacade.findArtistById(id);
        return ResponseEntity.ok(artist);
    }

}
