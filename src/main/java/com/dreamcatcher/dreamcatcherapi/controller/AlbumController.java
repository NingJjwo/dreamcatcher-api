package com.dreamcatcher.dreamcatcherapi.controller;

import com.dreamcatcher.dreamcatcherapi.dtos.AlbumDetailDto;
import com.dreamcatcher.dreamcatcherapi.dtos.AlbumDto;
import com.dreamcatcher.dreamcatcherapi.exception.DreamcatcherException;
import com.dreamcatcher.dreamcatcherapi.mappers.AlbumMapper;
import com.dreamcatcher.dreamcatcherapi.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private AlbumMapper albumMapper;

    @GetMapping
    public ResponseEntity<List<AlbumDto>> getAllAlbums() {
        List<AlbumDto> albums = albumRepository.findAll()
                .stream()
                .map(albumMapper::toDTO)
                .collect(Collectors.toList());
        return albums.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(albums);
    }

    @GetMapping("/getByAlbumSongs")
    public ResponseEntity<AlbumDetailDto> getAlbumByTitle(@RequestParam(required = false) String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new DreamcatcherException(400, "Please provide a title");
        }
        Optional<AlbumDetailDto> album = albumRepository.findByTitle(title)
                .map(albumMapper::toDetailDTO);
        return album.map(ResponseEntity::ok)
                .orElseThrow(() -> new DreamcatcherException(404, "Album with title " + title + " not found"));
    }
}
