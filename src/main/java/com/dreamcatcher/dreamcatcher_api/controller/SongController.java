package com.dreamcatcher.dreamcatcher_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamcatcher.dreamcatcher_api.dto.SongResponseDto;
import com.dreamcatcher.dreamcatcher_api.service.SongService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
@Tag(name = "Songs", description = "K-pop songs")
public class SongController {

    private final SongService songService;

    @GetMapping
    @Operation(summary = "List all songs")
    public List<SongResponseDto> getAllSongs() {
        return songService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a song by id")
    public SongResponseDto getSongById(@PathVariable Long id) {
        return songService.findById(id);
    }
}