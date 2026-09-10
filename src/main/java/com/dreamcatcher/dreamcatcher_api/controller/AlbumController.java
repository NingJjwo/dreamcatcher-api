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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
@Tag(name = "Albums", description = "K-pop albums and releases")
public class AlbumController {

    private final AlbumService albumService;
    private final SongService songService;

    @GetMapping
    @Operation(summary = "List all albums")
    public List<AlbumResponseDto> getAllAlbums() {
        return albumService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an album by id")
    public AlbumResponseDto getAlbumById(@PathVariable Long id) {
        return albumService.findById(id);
    }

    @GetMapping("/{albumId}/songs")
    @Operation(summary = "List the songs of an album")
    public List<SongResponseDto> getSongsByAlbumId(@PathVariable Long albumId) {
        return songService.findAllByAlbumId(albumId);
    }
}