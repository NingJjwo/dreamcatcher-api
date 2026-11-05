package com.dreamcatcher.dreamcatcher_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreamcatcher.dreamcatcher_api.dto.IdolResponseDto;
import com.dreamcatcher.dreamcatcher_api.exception.ResourceNotFoundException;
import com.dreamcatcher.dreamcatcher_api.model.Idol;
import com.dreamcatcher.dreamcatcher_api.repository.IdolRepository;
import com.dreamcatcher.dreamcatcher_api.util.AssetUrl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IdolService {

    private final IdolRepository idolRepository;
    private final AssetUrl assetUrl;

    public List<IdolResponseDto> findAll() {
        return idolRepository.findAll().stream().map(this::toDto).toList();
    }

    public IdolResponseDto findById(Long id) {
        return idolRepository.findById(id).map(this::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Idol", id));
    }

    public List<IdolResponseDto> findAllByGroupId(Long groupId) {
        return idolRepository.findByGroup_Id(groupId).stream().map(this::toDto).toList();
    }

    private IdolResponseDto toDto(Idol idol) {
        return IdolResponseDto.from(idol, assetUrl);
    }
}
