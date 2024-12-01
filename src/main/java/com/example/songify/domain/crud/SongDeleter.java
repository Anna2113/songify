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
class SongDeleter {
    private final SongRepository songRepository;

    void deleteById(final Long id) {
        songRepository.deleteById(id);
    }

}
