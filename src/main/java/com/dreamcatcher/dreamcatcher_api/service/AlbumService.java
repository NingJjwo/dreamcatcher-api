package com.dreamcatcher.dreamcatcher_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreamcatcher.dreamcatcher_api.dto.AlbumResponseDto;
import com.dreamcatcher.dreamcatcher_api.exception.ResourceNotFoundException;
import com.dreamcatcher.dreamcatcher_api.repository.AlbumRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AlbumService {

    private final AlbumRepository albumRepository;

    @Value("${app.assets.base-url}")
    private String assetBaseUrl;

    public List<AlbumResponseDto> findAll() {
        return albumRepository.findAll().stream()
                .map(album -> AlbumResponseDto.from(album, assetBaseUrl))
                .toList();
    }

    public AlbumResponseDto findById(Long id) {
        return albumRepository.findById(id)
                .map(album -> AlbumResponseDto.from(album, assetBaseUrl))
                .orElseThrow(() -> new ResourceNotFoundException("Album", id));
    }

    public List<AlbumResponseDto> findAllByGroupId(Long groupId) {
        return albumRepository.findByGroup_Id(groupId).stream()
                .map(album -> AlbumResponseDto.from(album, assetBaseUrl))
                .toList();
    }
}
