package com.dreamcatcher.dreamcatcherapi.controller;

import com.dreamcatcher.dreamcatcherapi.dtos.AlbumDetailDto;
import com.dreamcatcher.dreamcatcherapi.dtos.AlbumDto;
import com.dreamcatcher.dreamcatcherapi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<AlbumDto>> getAllAlbums() {
        List<AlbumDto> albums = albumService.getAllAlbums();
        return ResponseEntity.ok(albums);
    }

    @GetMapping(params = "year")
    public ResponseEntity<List<AlbumDto>> getAlbumsByYear(@RequestParam int year) {
        List<AlbumDto> albums = albumService.getAlbumsByYear(year);
        return ResponseEntity.ok(albums);
    }

    @GetMapping("/{title}/songs")
    public ResponseEntity<AlbumDetailDto> getAlbumSongs(@PathVariable String title) {
        AlbumDetailDto albumDetail = albumService.getAlbumDetail(title);
        return ResponseEntity.ok(albumDetail);
    }

    @GetMapping("/{title}")
    public ResponseEntity<AlbumDto> getAlbum(@PathVariable String title) {
        AlbumDto album = albumService.getAlbum(title);
        return ResponseEntity.ok(album);
    }

    @GetMapping(params = "releasedAs")
    public ResponseEntity<List<AlbumDto>> getAlbumsByGroupName(@RequestParam String releasedAs) {
        List<AlbumDto> albums = albumService.getAlbumsByReleasedAs(releasedAs);
        return ResponseEntity.ok(albums);
    }
}