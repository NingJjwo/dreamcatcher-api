package com.dreamcatcher.dreamcatcher_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dreamcatcher.dreamcatcher_api.dto.SongResponseDto;
import com.dreamcatcher.dreamcatcher_api.service.SongService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping
    public ResponseEntity<List<SongResponseDto>> getAllSongs() {
        return ResponseEntity.ok(songService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongResponseDto> getSongById(@PathVariable Long id) {
        return ResponseEntity.ok(songService.findById(id));
    }

    @GetMapping("/album/{albumId}")
    public ResponseEntity<List<SongResponseDto>> getSongsByAlbum(@PathVariable Long albumId) {
        return ResponseEntity.ok(songService.findAllByAlbumId(albumId));
    }
}
