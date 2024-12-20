package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.AlbumDto;
import com.example.songify.domain.crud.dto.ArtistDto;
import com.example.songify.domain.crud.dto.ArtistRequestDto;
import com.example.songify.domain.crud.dto.SongDto;
import com.example.songify.domain.crud.dto.SongLanguageDto;
import com.example.songify.domain.crud.exception.AlbumNotFoundException;
import com.example.songify.domain.crud.exception.SongNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Service
@Log4j2
@AllArgsConstructor
class ArtistAdder {
    private final ArtistRepository artistRepository;
    private final AlbumAdder albumAdder;
    private final SongAdder songAdder;

    ArtistDto addArtist(final String name) {
        Artist artist = saveArtist(name);
        return new ArtistDto(artist.getId(), artist.getName());
    }

    private Artist saveArtist(final String name) {
        Artist artist = new Artist(name);
        Artist artistToSave = artistRepository.save(artist);
        return artistToSave;
    }

    ArtistDto addArtistWithDefaultAlbumAndSong(final ArtistRequestDto dto) {
        String artistName = dto.name();
        Artist savedArtist = saveArtistWithDefaultAlbumAndSong(artistName);
        return new ArtistDto(savedArtist.getId(), savedArtist.getName());
    }

    private Artist saveArtistWithDefaultAlbumAndSong(final String artistName) {
//        Artist artist = new Artist(artistName);
//        Album album = new Album();
//        album.setTitle("Default-album: " + UUID.randomUUID());
//        album.setReleaseDate(LocalDateTime.now().toInstant(ZoneOffset.UTC));
//        Song song = new Song("Default-song-name: " + UUID.randomUUID());

        Album album = albumAdder.addAlbum("Default-album: " + UUID.randomUUID(), LocalDateTime.now().toInstant(ZoneOffset.UTC));

        Song song = songAdder.addSongAndGetEntity(new SongRequestDto(
                "Default-song-name: " + UUID.randomUUID(),
                LocalDateTime.now().toInstant(ZoneOffset.UTC),
                0L,
                SongLanguageDto.OTHER
        ));
        Artist artist = new Artist(artistName);
        album.addSongToAlbum(song);
        artist.addAlbum(album);
        return artistRepository.save(artist);
    }
}
