package com.dreamcatcher.dreamcatcher_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreamcatcher.dreamcatcher_api.dto.SongResponseDto;
import com.dreamcatcher.dreamcatcher_api.exception.ResourceNotFoundException;
import com.dreamcatcher.dreamcatcher_api.repository.SongRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SongService {

    private final SongRepository songRepository;

    public List<SongResponseDto> findAll() {
        return songRepository.findAll().stream()
                .map(SongResponseDto::from)
                .toList();
    }

    public SongResponseDto findById(Long id) {
        return songRepository.findById(id)
                .map(SongResponseDto::from)
                .orElseThrow(() -> new ResourceNotFoundException("Song", id));
    }

    public List<SongResponseDto> findAllByAlbumId(Long albumId) {
        return songRepository.findByAlbumAlbumId(albumId).stream()
                .map(SongResponseDto::from)
                .toList();
    }
}
