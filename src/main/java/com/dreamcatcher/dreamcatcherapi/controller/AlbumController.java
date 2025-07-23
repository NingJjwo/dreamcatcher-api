package com.dreamcatcher.dreamcatcherapi.controller;

import com.dreamcatcher.dreamcatcherapi.dtos.AlbumDetailDto;
import com.dreamcatcher.dreamcatcherapi.dtos.AlbumDto;
import com.dreamcatcher.dreamcatcherapi.mappers.AlbumMapper;
import com.dreamcatcher.dreamcatcherapi.model.Album;
import com.dreamcatcher.dreamcatcherapi.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getAlbumsByYear")
    public ResponseEntity<List<AlbumDto>> getAlbumsByYear(@RequestParam int year) {
        List<AlbumDto> albums = albumRepository.findByYear(year)
                .stream()
                .map(albumMapper::toDTO)
                .collect(Collectors.toList());
        return albums.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(albums);
    }

    @GetMapping("/getAlbumSongs")
    public ResponseEntity<AlbumDetailDto> getAlbumByTitle(@RequestParam String title) {
        Optional<Album> albumOptional = albumRepository.findByTitle(title);
        return albumOptional.map(album -> {
            AlbumDetailDto albumDto = albumMapper.toDetailDTO(album);
            return ResponseEntity.ok(albumDto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/getAlbum")
    public ResponseEntity<AlbumDto> getAlbum(@RequestParam String title) {
        Optional<Album> albumOptional = albumRepository.findByTitle(title);
        return albumOptional.map(album -> ResponseEntity.ok(albumMapper.toDTO(album)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getAlbumByGroupName")
    public ResponseEntity<List<AlbumDto>> getAlbumsByGroupName(@RequestParam String releasedAs) {
        List<AlbumDto> albums = albumRepository.findByReleasedAs(releasedAs)
                .stream()
                .map(albumMapper::toDTO)
                .collect(Collectors.toList());
        return albums.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(albums);
    }
}