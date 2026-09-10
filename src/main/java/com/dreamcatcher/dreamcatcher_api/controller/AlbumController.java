package com.dreamcatcher.dreamcatcher_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamcatcher.dreamcatcher_api.dto.AlbumResponseDto;
import com.dreamcatcher.dreamcatcher_api.dto.SongResponseDto;
import com.dreamcatcher.dreamcatcher_api.service.AlbumService;
import com.dreamcatcher.dreamcatcher_api.service.SongService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;
    private final SongService songService;

    @GetMapping
    public List<AlbumResponseDto> getAllAlbums() {
        return albumService.findAll();
    }

    @GetMapping("/{id}")
    public AlbumResponseDto getAlbumById(@PathVariable Long id) {
        return albumService.findById(id);
    }

    @GetMapping("/{albumId}/songs")
    public List<SongResponseDto> getSongsByAlbumId(@PathVariable Long albumId) {
        return songService.findAllByAlbumId(albumId);
    }
}