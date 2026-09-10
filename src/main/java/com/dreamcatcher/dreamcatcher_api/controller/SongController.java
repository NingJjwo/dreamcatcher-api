package com.dreamcatcher.dreamcatcher_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamcatcher.dreamcatcher_api.dto.SongResponseDto;
import com.dreamcatcher.dreamcatcher_api.service.SongService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping
    public List<SongResponseDto> getAllSongs() {
        return songService.findAll();
    }

    @GetMapping("/{id}")
    public SongResponseDto getSongById(@PathVariable Long id) {
        return songService.findById(id);
    }

    @GetMapping("/album/{albumId}")
    public List<SongResponseDto> getSongsByAlbum(@PathVariable Long albumId) {
        return songService.findAllByAlbumId(albumId);
    }
}