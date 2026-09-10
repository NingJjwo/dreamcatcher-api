package com.dreamcatcher.dreamcatcher_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamcatcher.dreamcatcher_api.dto.AlbumResponseDto;
import com.dreamcatcher.dreamcatcher_api.service.AlbumService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    public List<AlbumResponseDto> getAllAlbums() {
        return albumService.findAll();
    }

    @GetMapping("/{id}")
    public AlbumResponseDto getAlbumById(@PathVariable Long id) {
        return albumService.findById(id);
    }

    @GetMapping("/group/{groupId}")
    public List<AlbumResponseDto> getAlbumsByGroup(@PathVariable Long groupId) {
        return albumService.findAllByGroupId(groupId);
    }
}