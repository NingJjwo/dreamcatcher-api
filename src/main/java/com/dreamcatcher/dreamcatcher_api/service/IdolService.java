package com.dreamcatcher.dreamcatcher_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreamcatcher.dreamcatcher_api.dto.IdolResponseDto;
import com.dreamcatcher.dreamcatcher_api.exception.ResourceNotFoundException;
import com.dreamcatcher.dreamcatcher_api.repository.IdolRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IdolService {

    private final IdolRepository idolRepository;

    @Value("${app.assets.base-url}")
    private String assetBaseUrl;

    public List<IdolResponseDto> findAll() {
        return idolRepository.findAll().stream().map(idol -> IdolResponseDto.from(idol, assetBaseUrl)).toList();
    }

    public List<IdolResponseDto> findAll(String stageName) {
        if (stageName == null || stageName.isBlank()) {
            return findAll();
        }
        return idolRepository.findByStageNameContainingIgnoreCase(stageName.trim()).stream()
                .map(idol -> IdolResponseDto.from(idol, assetBaseUrl))
                .toList();
    }

    public IdolResponseDto findById(Long id) {
        return idolRepository.findById(id)
                .map(idol -> IdolResponseDto.from(idol, assetBaseUrl))
                .orElseThrow(() -> new ResourceNotFoundException("Idol", id));
    }

    public List<IdolResponseDto> findAllByGroupId(Long groupId) {
        return idolRepository.findByGroup_Id(groupId).stream().map(idol -> IdolResponseDto.from(idol, assetBaseUrl)).toList();
    }
}