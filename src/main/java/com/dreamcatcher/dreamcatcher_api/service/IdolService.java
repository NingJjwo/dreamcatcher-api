package com.dreamcatcher.dreamcatcher_api.service;

import java.util.List;

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

    public List<IdolResponseDto> findAll() {
        return idolRepository.findAll().stream().map(IdolResponseDto::from).toList();
    }

    public IdolResponseDto findById(Long id) {
        return idolRepository.findById(id)
                .map(IdolResponseDto::from)
                .orElseThrow(() -> new ResourceNotFoundException("Idol", id));
    }

    public List<IdolResponseDto> findAllByGroupId(Long groupId) {
        return idolRepository.findByGroupGroupId(groupId).stream().map(IdolResponseDto::from).toList();
    }

    public List<IdolResponseDto> findByStageName(String stageName) {
        if (stageName == null) {
            return List.of();
        }
        return idolRepository.findByStageNameContainingIgnoreCase(stageName.trim()).stream()
                .map(IdolResponseDto::from)
                .toList();
    }
}