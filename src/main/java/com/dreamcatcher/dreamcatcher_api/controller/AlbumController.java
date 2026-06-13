package com.dreamcatcher.dreamcatcher_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dreamcatcher.dreamcatcher_api.dto.AlbumResponseDto;
import com.dreamcatcher.dreamcatcher_api.service.AlbumService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping("/api/albums")
    public ResponseEntity<List<AlbumResponseDto>> getAllAlbums() {
        return ResponseEntity.ok(albumService.findAll());
    }

    @GetMapping("/api/albums/{id}")
    public ResponseEntity<AlbumResponseDto> getAlbumById(@PathVariable Long id) {
        return ResponseEntity.ok(albumService.findById(id));
    }

    @GetMapping("/api/groups/albums/{groupId}")
    public ResponseEntity<List<AlbumResponseDto>> getAlbumsByGroup(@PathVariable Long groupId) {
        return ResponseEntity.ok(albumService.findAllByGroupId(groupId));
    }
}
