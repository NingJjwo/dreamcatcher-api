package com.dreamcatcher.dreamcatcher_api.controller;

import java.awt.*;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
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

    @GetMapping("/group/{id}")
    @Operation(summary = "Get all albums from a specific group")
    public List<AlbumResponseDto> getAlbumsByGroupId(@PathVariable @NotBlank Long id){
        return albumService.findAllByGroupId(id);
    }

}