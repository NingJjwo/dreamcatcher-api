package com.dreamcatcher.dreamcatcherapi.controller;

import com.dreamcatcher.dreamcatcherapi.dtos.AlbumDetailDto;
import com.dreamcatcher.dreamcatcherapi.dtos.AlbumDto;
import com.dreamcatcher.dreamcatcherapi.mappers.AlbumMapper;
import com.dreamcatcher.dreamcatcherapi.model.Album;
import com.dreamcatcher.dreamcatcherapi.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
                .peek(Album::generateImageUrl)
                .map(albumMapper::toDTO)
                .collect(Collectors.toList());
        return albums.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(albums);
    }

    @GetMapping(params = "year")
    public ResponseEntity<List<AlbumDto>> getAlbumsByYear(@RequestParam int year) {
        List<AlbumDto> albums = albumRepository.findByYear(year)
                .stream()
                .peek(Album::generateImageUrl)
                .map(albumMapper::toDTO)
                .collect(Collectors.toList());
        return albums.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(albums);
    }

    @GetMapping("/{title}/songs")
    public ResponseEntity<AlbumDetailDto> getAlbumByTitle(@PathVariable String title) {
        Optional<Album> albumOptional = albumRepository.findByTitleContaining(title);
        return albumOptional.map(album -> {
            album.generateImageUrl();
            AlbumDetailDto albumDto = albumMapper.toDetailDTO(album);
            return ResponseEntity.ok(albumDto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/{title}")
    public ResponseEntity<AlbumDto> getAlbum(@PathVariable String title) {
        Optional<Album> albumOptional = albumRepository.findByTitleContaining(title);
        return albumOptional.map(album -> {
            album.generateImageUrl();
            return ResponseEntity.ok(albumMapper.toDTO(album));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(params = "releasedAs")
    public ResponseEntity<List<AlbumDto>> getAlbumsByGroupName(@RequestParam String releasedAs) {
        List<AlbumDto> albums = albumRepository.findByReleasedAs(releasedAs)
                .stream()
                .peek(Album::generateImageUrl)
                .map(albumMapper::toDTO)
                .collect(Collectors.toList());
        return albums.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(albums);
    }
}