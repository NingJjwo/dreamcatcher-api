package com.dreamcatcher.dreamcatcher_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dreamcatcher.dreamcatcher_api.dto.AlbumResponseDto;
import com.dreamcatcher.dreamcatcher_api.service.AlbumService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<AlbumResponseDto>> getAllAlbums() {
        return ResponseEntity.ok(albumService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumResponseDto> getAlbumById(@PathVariable Long id) {
        return ResponseEntity.ok(albumService.findById(id));
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<AlbumResponseDto>> getAlbumsByGroup(@PathVariable Long groupId) {
        return ResponseEntity.ok(albumService.findAllByGroupId(groupId));
    }
}
