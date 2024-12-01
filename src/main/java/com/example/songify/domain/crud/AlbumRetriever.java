package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.AlbumDto;
import com.example.songify.domain.crud.dto.AlbumWithSongsAndArtistsDto;
import com.example.songify.domain.crud.dto.AlbumWithSongsDto;
import com.example.songify.domain.crud.dto.SongDto;
import com.example.songify.domain.crud.exception.AlbumNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
class AlbumRetriever {
    private final AlbumRepository albumRepository;

    Album findById(final Long albumId) {
        return albumRepository.findById(albumId)
                .orElseThrow(() -> new AlbumNotFoundException("Album with id: " + albumId + " not found"));
    }


    List<AlbumDto> findAllAlbums() {
        return albumRepository.findAll()
                .stream()
                .map(album -> new AlbumDto(
                        album.getId(),
                        album.getTitle()
                ))
                .collect(Collectors.toList());
    }

    AlbumDto findAlbumById(final Long albumId) {
        return albumRepository.findAlbumById(albumId)
                .map(album -> AlbumDto.builder()
                        .id(album.id())
                        .title(album.title())
                        .build())
                .orElseThrow(() -> new AlbumNotFoundException("Album with id: " + albumId + " not found."));
    }

    AlbumWithSongsDto findAlbumByIdWithSongs(final Long id) {
        Album album = albumRepository.findAllSongsByAlbumId(id)
                .orElseThrow(() -> new AlbumNotFoundException("Album with id: " + id + " not found"));

        Set<Song> songs = album.getSongs();

        Set<SongDtoWithoutArtists> allSongs = songs.stream()
                .map(song -> new SongDtoWithoutArtists(
                        song.getId(),
                        song.getName()
                ))
                .collect(Collectors.toSet());

//        Set<SongDto> allSongs = songs.stream()
//                .map(song -> new SongDto(
//                        song.getId(),
//                        song.getName(),
//                        song.getArtist().toString()
//                ))
//                .collect(Collectors.toSet());

        AlbumDto albumDto = new AlbumDto(album.getId(), album.getTitle());

        return new AlbumWithSongsDto(albumDto, allSongs);


    }

    AlbumWithSongsAndArtistsDto findAlbumByIdWithSongsAndArtists(final Long id) {
        Album album = albumRepository.findAllSongsAndArtistsByAlbumId(id)
                .orElseThrow(() -> new AlbumNotFoundException("Album with id: " + id + " not found"));

        Set<Song> songs = album.getSongs();
        Set<SongDto> allSongs = songs.stream()
                .map(song -> new SongDto(
                        song.getId(),
                        song.getName(),
                        song.getArtist().getName()
                ))
                .collect(Collectors.toSet());

//        Set<Artist> artists = album.getArtists();
//        Set<ArtistDto> allArtists = artists.stream()
//                .map(artist -> new ArtistDto(
//                        artist.getId(),
//                        artist.getName()
//                ))
//                .collect(Collectors.toSet());
//
        AlbumDto albumDto = new AlbumDto(album.getId(), album.getTitle());

        return new AlbumWithSongsAndArtistsDto(albumDto, allSongs);

    }
}
