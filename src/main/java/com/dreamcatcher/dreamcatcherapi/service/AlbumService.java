package com.dreamcatcher.dreamcatcherapi.service;

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

    public List<AlbumDto> getAllAlbumsDto() {
        List<Album> albums = albumRepository.findAll();
        albums.forEach(Album::generateImageUrl);
        return albums.stream().map(albumMapper::toDTO).collect(Collectors.toList());
    }

    public AlbumDto getAlbumDto(String title) {
        Album album = albumRepository.findByTitleContaining(title)
                .orElseThrow(() -> new DreamcatcherException(404, "No album found containing " + title));
        album.generateImageUrl();
        return albumMapper.toDTO(album);
    }
}