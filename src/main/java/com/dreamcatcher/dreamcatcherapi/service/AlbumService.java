package com.dreamcatcher.dreamcatcherapi.service;

import com.dreamcatcher.dreamcatcherapi.dtos.AlbumDetailDto;
import com.dreamcatcher.dreamcatcherapi.dtos.AlbumDto;
import com.dreamcatcher.dreamcatcherapi.exception.DreamcatcherException;
import com.dreamcatcher.dreamcatcherapi.mappers.AlbumMapper;
import com.dreamcatcher.dreamcatcherapi.model.Album;
import com.dreamcatcher.dreamcatcherapi.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AlbumMapper albumMapper;

    public List<AlbumDto> getAllAlbums() {
        List<Album> albums = albumRepository.findAll();
        albums.forEach(Album::generateImageUrl);
        return albums.stream().map(albumMapper::toDTO).collect(Collectors.toList());
    }

    public List<AlbumDto> getAlbumsByYear(int year) {
        List<Album> albums = albumRepository.findByYear(year);
        albums.forEach(Album::generateImageUrl);
        return albums.stream().map(albumMapper::toDTO).collect(Collectors.toList());
    }

    public List<AlbumDto> getAlbumsByReleasedAs(String releasedAs) {
        List<Album> albums = albumRepository.findByReleasedAs(releasedAs);
        albums.forEach(Album::generateImageUrl);
        return albums.stream().map(albumMapper::toDTO).collect(Collectors.toList());
    }

    public AlbumDto getAlbum(String title) {
        Album album = albumRepository.findByTitleContaining(title)
                .orElseThrow(() -> new DreamcatcherException(404, "No album found containing " + title));
        album.generateImageUrl();
        return albumMapper.toDTO(album);
    }

    public AlbumDetailDto getAlbumDetail(String title) {
        Album album = albumRepository.findByTitleContaining(title)
                .orElseThrow(() -> new DreamcatcherException(404, "No album found containing " + title));
        album.generateImageUrl();
        return albumMapper.toDetailDTO(album);
    }
}