package com.example.songify.domain.crud;

class SongifyCrudFacadeConfiguration {

    public static SongifyCrudFacade createSongifyCrude(final SongRepository songRepository,
                                                       final GenreRepository genreRepository,
                                                       final ArtistRepository artistRepository,
                                                       final AlbumRepository albumRepository) {
        SongRetriever songRetriever = new SongRetriever(songRepository);
        SongUpdater songUpdater = new SongUpdater(songRepository);
        AlbumAdder albumAdder = new AlbumAdder(albumRepository, songRetriever);
        ArtistRetriever artistRetriever = new ArtistRetriever(artistRepository);
        AlbumRetriever albumRetriever = new AlbumRetriever(albumRepository);
        GenreDeleter genreDeleter = new GenreDeleter(genreRepository);
        SongDeleter songDeleter = new SongDeleter(songRepository);
        GenreRetriever genreRetriever = new GenreRetriever(genreRepository);
        SongAdder songAdder = new SongAdder(songRepository);
        ArtistAdder artistAdder = new ArtistAdder(artistRepository, albumAdder, songAdder);
        GenreAdder genreAdder = new GenreAdder(genreRepository);
        AlbumDeleter albumDeleter = new AlbumDeleter(albumRepository);
        ArtistDeleter artistDeleter = new ArtistDeleter(artistRepository, artistRetriever, albumRetriever, songDeleter, albumDeleter);
        ArtistAssigner artistAssigner = new ArtistAssigner(artistRetriever, albumRetriever);
        ArtistUpdater artistUpdater = new ArtistUpdater(artistRetriever, artistRepository);
        return new SongifyCrudFacade(
                artistAdder,
                genreAdder,
                songAdder,
                albumAdder,
                artistAssigner,
                artistRetriever,
                genreRetriever,
                albumRetriever,
                songRetriever,
                songDeleter,
                genreDeleter,
                artistDeleter,
                songUpdater,
                artistUpdater
        );
    }
}
