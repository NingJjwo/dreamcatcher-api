package com.dreamcatcher.dreamcatcher_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreamcatcher.dreamcatcher_api.dto.GroupDetailResponseDto;
import com.dreamcatcher.dreamcatcher_api.dto.GroupResponseDto;
import com.dreamcatcher.dreamcatcher_api.exception.ResourceNotFoundException;
import com.dreamcatcher.dreamcatcher_api.repository.GroupRepository;
import com.dreamcatcher.dreamcatcher_api.util.AssetUrl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GroupService {

    private final GroupRepository groupRepository;
    private final AssetUrl assetUrl;

    public List<GroupResponseDto> findAll() {
        return groupRepository.findAll().stream().map(group -> GroupResponseDto.from(group, assetUrl)).toList();
    }

    public GroupDetailResponseDto findById(Long id) {
        return groupRepository.findWithMembersById(id)
                .map(group -> GroupDetailResponseDto.from(group, assetUrl))
                .orElseThrow(() -> new ResourceNotFoundException("Group", id));
    }
}
