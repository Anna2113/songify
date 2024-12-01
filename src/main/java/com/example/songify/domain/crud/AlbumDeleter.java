package com.example.songify.domain.crud;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Log4j2
@AllArgsConstructor
@Transactional
class AlbumDeleter {

    private final AlbumRepository albumRepository;

    void deleteAllAlbumsById(final Set<Long> albumToDelete) {
        albumRepository.deleteByIdIn(albumToDelete);
    }
}
