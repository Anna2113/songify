package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.AlbumDto;
import com.example.songify.domain.crud.dto.AlbumRequestDto;
import com.example.songify.domain.crud.dto.AlbumWithSongsDto;
import com.example.songify.domain.crud.dto.ArtistDto;
import com.example.songify.domain.crud.dto.ArtistRequestDto;
import com.example.songify.domain.crud.dto.GenreDto;
import com.example.songify.domain.crud.dto.GenreRequestDto;
import com.example.songify.domain.crud.dto.SongDto;
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

    public ArtistDto addArtist(ArtistRequestDto dto) {
        return artistAdder.addArtist(dto.name());
    }

    public GenreDto addGenre(GenreRequestDto dto){
        return genreAdder.addGenre(dto.name());
    }

    public SongDto addSong(SongRequestDto dto){
        return songAdder.addSong(dto);
    }

    public AlbumDto addAlbumWithSong(AlbumRequestDto dto){
        return albumAdder.addAlbum(dto.songId(), dto.title(), dto.releaseDate());
    }

    public void addArtistToAlbum(Long artistId, Long albumId){
        artistAssigner.addArtistToAlbum(artistId, albumId);
    }

    public ArtistDto addArtistWithDefaultAlbumAndSong(ArtistRequestDto dto){
        return artistAdder.addArtistWithDefaultAlbumAndSong(dto);
    }

    //TODO: Dodanie piosenki do istniejącego artysty.

    public Set<ArtistDto> findAllArtists(){
        return artistRetriever.findAllArtists();
    }

    public Set<GenreDto> findAllGenres(){
        return genreRetriever.findAllGenres();
    }

    public List<AlbumDto> findAllAlbums(){
        return albumRetriever.findAllAlbums();
    }

    public List<SongDto> findAllSongs(){
        return songRetriever.findAllSongs();
    }

    public ArtistDto findArtistById(Long artistId){
        return artistRetriever.findArtistById(artistId);
    }

    public GenreDto findGenreById(Long genreId){
        return genreRetriever.findGenreById(genreId);
    }

    public AlbumDto findAlbumById(Long albumId){
        return albumRetriever.findAlbumById(albumId);
    }

    public SongDto findSongById(Long songId){
        return songRetriever.findSongById(songId);
    }

    public AlbumWithSongsDto findAlbymByIdWithSongs(Long id){
        return albumRetriever.findAlbumByIdWithSongs(id);
    }

}
