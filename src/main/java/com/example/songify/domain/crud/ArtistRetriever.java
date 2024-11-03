package com.example.songify.domain.crud;

import com.example.songify.domain.crud.dto.ArtistDto;
import com.example.songify.domain.crud.exception.ArtistNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
class ArtistRetriever {
    private final ArtistRepository artistRepository;

    Artist findById(final Long artistId) {
        return artistRepository.findById(artistId)
                .orElseThrow(() -> new ArtistNotFoundException(artistId.toString()));
    }

    Set<ArtistDto> findAllArtists() {
        return artistRepository.findAll()
                .stream()
                .map(artist -> new ArtistDto(
                        artist.getId(),
                        artist.getName()
                ))
                .collect(Collectors.toSet());
    }

    ArtistDto findArtistById(final Long artistId) {
        return artistRepository.findById(artistId)
                .map(artist -> ArtistDto.builder()
                        .id(artist.getId())
                        .name(artist.getName())
                        .build())
                .orElseThrow(() -> new ArtistNotFoundException(artistId.toString()));
    }
}
