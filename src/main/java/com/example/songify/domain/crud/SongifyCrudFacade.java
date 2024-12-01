package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.AlbumDto;
import com.example.songify.domain.crud.dto.AlbumRequestDto;
import com.example.songify.domain.crud.dto.AlbumWithSongsAndArtistsDto;
import com.example.songify.domain.crud.dto.AlbumWithSongsDto;
import com.example.songify.domain.crud.dto.ArtistDto;
import com.example.songify.domain.crud.dto.ArtistRequestDto;
import com.example.songify.domain.crud.dto.GenreDto;
import com.example.songify.domain.crud.dto.GenreRequestDto;
import com.example.songify.domain.crud.dto.SongDto;
import com.example.songify.domain.crud.dto.SongRequestDtoWithArtist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional
public class SongifyCrudFacade {

    private final ArtistAdder artistAdder;
    private final GenreAdder genreAdder;
    private final SongAdder songAdder;
    private final AlbumAdder albumAdder;
    private final ArtistAssigner artistAssigner;
    private final ArtistRetriever artistRetriever;
    private final GenreRetriever genreRetriever;
    private final AlbumRetriever albumRetriever;
    private final SongRetriever songRetriever;
    private final SongDeleter songDeleter;
    private final GenreDeleter genreDeleter;
    private final ArtistDeleter artistDeleter;
    private final SongUpdater songUpdater;
    private final ArtistUpdater artistUpdater;

    public ArtistDto addArtist(ArtistRequestDto dto) {
        return artistAdder.addArtist(dto.name());
    }

    public GenreDto addGenre(GenreRequestDto dto) {
        return genreAdder.addGenre(dto.name());
    }

    public SongDto addSong(SongRequestDtoWithArtist dto) {
        return songAdder.addSong(dto);
    }

    public AlbumDto addAlbumWithSong(AlbumRequestDto dto) {
        return albumAdder.addAlbum(dto.songId(), dto.title(), dto.releaseDate());
    }

//    public void addArtistToAlbum(Long artistId, Long albumId) {
//        artistAssigner.addArtistToAlbum(artistId, albumId);
//    }

    public ArtistDto addArtistWithDefaultAlbumAndSong(ArtistRequestDto dto) {
        return artistAdder.addArtistWithDefaultAlbumAndSong(dto);
    }

    public Set<ArtistDto> findAllArtists() {
        return artistRetriever.findAllArtists();
    }

    public Set<GenreDto> findAllGenres() {
        return genreRetriever.findAllGenres();
    }

    public List<AlbumDto> findAllAlbums() {
        return albumRetriever.findAllAlbums();
    }

    public List<SongDtoWithoutArtists> findAllSongs() {
        return songRetriever.findAllSongs();
    }

    public ArtistDto findArtistById(Long artistId) {
        return artistRetriever.findArtistById(artistId);
    }

    public GenreDto findGenreById(Long genreId) {
        return genreRetriever.findGenreById(genreId);
    }

    public AlbumDto findAlbumById(Long albumId) {
        return albumRetriever.findAlbumById(albumId);
    }

    public SongDto findSongById(Long songId) {
        return songRetriever.findSongById(songId);
    }

    public AlbumWithSongsDto findAlbumByIdWithSongs(Long id) {
        return albumRetriever.findAlbumByIdWithSongs(id);
    }

    public AlbumWithSongsAndArtistsDto findAlbumByIdWithSongsAndArtists(Long id) {
        return albumRetriever.findAlbumByIdWithSongsAndArtists(id);
    }

//    public AlbumWithArtistsDto findAlbumByIdWithArtists(Long id){
//        return albumRetriever.findAlbumByIdWithArtists(id);
//    }

    //TODO: Add genre to song or add genre to album.

    public void deleteSongById(Long id) {
        songRetriever.existsById(id);
        songDeleter.deleteById(id);
    }

    public void deleteGenreById(Long id) {
        genreRetriever.existsById(id);
        genreDeleter.deleteById(id);
    }

//    public void deleteArtistByIdWithAlbumsAndSongs(Long artistId) {
//        artistDeleter.deleteArtistByIdWithAlbumsAndSongs(artistId);
//    }

    public void updateSongById(Long id, SongDtoWithoutArtists newSongDto) {
        songRetriever.existsById(id);
        Song songValidatedAndReadyToUpdate = new Song(newSongDto.name());
        songUpdater.updateById(id, songValidatedAndReadyToUpdate);
    }

    public ArtistDto updateArtistNameById(Long artistId, String name) {
        return artistUpdater.updateArtistNameById(artistId, name);
    }


}
