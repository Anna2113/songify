package com.example.songify.domain.crud;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@Transactional
@AllArgsConstructor
class SongUpdater {

    private final  SongRepository songRepository;


    void updateById(final Long id, final Song newSong) {
        songRepository.updateById(id, newSong);
    }
}
