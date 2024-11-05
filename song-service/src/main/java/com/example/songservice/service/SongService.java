package com.example.songservice.service;

import com.example.songservice.entity.SongEntity;
import com.example.songservice.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private RestTemplate restTemplate;

    public SongEntity addSong(SongEntity songEntity) {
        checkExistenceOfResource(songEntity);
        return this.songRepository.save(songEntity);
    }

    public Optional<SongEntity> getSong(final Integer id) {
        return this.songRepository.findById(id);
    }

    public void deleteSong(final Integer id) {
        this.songRepository.deleteById(id);

    }

    private void checkExistenceOfResource(final SongEntity songEntity) {
        final String url = "http://resource:8080/resource-api/resources/" + songEntity.getResourceId();
        final String response = restTemplate.getForObject(url, String.class);
        if (!response.equals("200")) {
            throw new IllegalArgumentException("Song metadata is missing");
        }
    }
}
