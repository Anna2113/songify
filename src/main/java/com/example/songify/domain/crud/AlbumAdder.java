package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.AlbumDto;
import com.example.songify.domain.crud.dto.ArtistDto;
import com.example.songify.domain.crud.dto.SongDto;
import com.example.songify.domain.crud.exception.AlbumNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Log4j2
@AllArgsConstructor
class AlbumAdder {

    private final AlbumRepository albumRepository;
    private final SongRetriever songRetriever;

    AlbumDto addAlbum(final Set<Long> songsId, final String title, final Instant releaseDate) {
        Set<Song> songs = songsId.stream()
                .map(songRetriever::findById)
                .collect(Collectors.toSet());
        Album album = new Album();
        album.setTitle(title);
        album.addSongToAlbum(songs);
        album.setReleaseDate(releaseDate);
        Album savedAlbum = albumRepository.save(album);
        return new AlbumDto(savedAlbum.getId(), savedAlbum.getTitle());
    }

    Album addAlbum(final String title, final Instant releaseDate) {
        Album album = new Album();
        album.setTitle(title);
        album.setReleaseDate(releaseDate);
        return albumRepository.save(album);
    }
}
