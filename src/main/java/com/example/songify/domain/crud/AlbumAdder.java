package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.AlbumDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

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
}
