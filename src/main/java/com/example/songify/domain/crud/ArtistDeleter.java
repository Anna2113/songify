package com.example.songify.domain.crud;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
@Transactional
class ArtistDeleter {

    private final ArtistRepository artistRepository;
    private final ArtistRetriever artistRetriever;
    private final AlbumRetriever albumRetriever;
    private final SongDeleter songDeleter;
    private final AlbumDeleter albumDeleter;

//TODO: DELETE Artists

//    void deleteArtistByIdWithAlbumsAndSongs(final Long artistId) {
//        Artist artist = artistRetriever.findById(artistId);
//        Set<Album> artistAlbums = albumRetriever.findAlbumsByArtistId(artist.getId());
//        if (artistAlbums.isEmpty()) {
//            log.info("Artist with id: " + artistId + " have 0 albums");
//            artistRepository.deleteById(artistId);
//            return;
//        }
//
//        Set<Album> albumsWithOnlyOneArtist = artistAlbums.stream()
//                .filter(album -> album.getArtists().size() == 1)
//                .collect(Collectors.toSet());
//
//        Set<Long> allSongsIdsFromAllAlbumsWhereWasOnlyThisArtist = albumsWithOnlyOneArtist
//                .stream()
//                .flatMap(album -> album.getSongs().stream())
//                .map(Song::getId)
//                .collect(Collectors.toSet());
//
//        songDeleter.deleteAllSongsId(allSongsIdsFromAllAlbumsWhereWasOnlyThisArtist);
//
//        Set<Long> albumIdsToDelete = albumsWithOnlyOneArtist.stream()
//                .map(Album::getId)
//                .collect(Collectors.toSet());
//
//        albumDeleter.deleteAllAlbumsById(albumIdsToDelete);
//
//        artistAlbums.stream()
//                .filter(album -> album.getArtists().size() >= 2)
//                .forEach(album -> album.removeArtist(artist));
//
//        artistRepository.deleteById(artistId);
//
//
//    }
}
