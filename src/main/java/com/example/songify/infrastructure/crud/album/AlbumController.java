package com.example.songify.infrastructure.crud.album;

import com.example.songify.domain.crud.SongifyCrudFacade;
import com.example.songify.domain.crud.dto.AlbumDto;
import com.example.songify.domain.crud.dto.AlbumRequestDto;
import com.example.songify.domain.crud.dto.AlbumWithSongsAndArtistsDto;
import com.example.songify.domain.crud.dto.AlbumWithSongsDto;
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
@RequestMapping("/albums")
class AlbumController {

    private final SongifyCrudFacade songifyCrudFacade;

    @PostMapping()
    ResponseEntity<AlbumDto> postAlbum(@RequestBody AlbumRequestDto albumRequestDto){
        AlbumDto albumDto = songifyCrudFacade.addAlbumWithSong(albumRequestDto);
        return ResponseEntity.ok(albumDto);
    }

    @GetMapping
    ResponseEntity<AllAlbumsDto> getAlbums(){
        List<AlbumDto> allAlbums = songifyCrudFacade.findAllAlbums();
        AllAlbumsDto albums = AlbumControllerMapper.mapFromAlbumToAllAlbumsDto(allAlbums);
        return ResponseEntity.ok(albums);
    }

    @GetMapping("/{id}")
    ResponseEntity<AlbumDto> getAlbum(@PathVariable Long id){
        AlbumDto album = songifyCrudFacade.findAlbumById(id);
        return ResponseEntity.ok(album);
    }

    @GetMapping("/album/songs/{id}")
    ResponseEntity<AlbumWithSongsDto> getAlbumWithSongs(@PathVariable Long id){
        AlbumWithSongsDto albumByIdWithSongs = songifyCrudFacade.findAlbumByIdWithSongs(id);
        return ResponseEntity.ok(albumByIdWithSongs);
    }

    @GetMapping("/album/songs/artists/{id}")
    ResponseEntity<AlbumWithSongsAndArtistsDto> getAlbumWithSongsAndArtists(@PathVariable Long id){
        AlbumWithSongsAndArtistsDto albumByIdWithSongsAndArtists = songifyCrudFacade.findAlbumByIdWithSongsAndArtists(id);
        return ResponseEntity.ok(albumByIdWithSongsAndArtists);
    }
}
