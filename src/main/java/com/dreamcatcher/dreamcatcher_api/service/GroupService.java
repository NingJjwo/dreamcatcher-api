package com.dreamcatcher.dreamcatcher_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreamcatcher.dreamcatcher_api.dto.GroupDetailResponseDto;
import com.dreamcatcher.dreamcatcher_api.dto.GroupResponseDto;
import com.dreamcatcher.dreamcatcher_api.exception.ResourceNotFoundException;
import com.dreamcatcher.dreamcatcher_api.repository.GroupRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GroupService {

    private final GroupRepository groupRepository;

    public List<GroupResponseDto> findAll() {
        return groupRepository.findAll().stream().map(GroupResponseDto::from).toList();
    }

    public GroupDetailResponseDto findById(Long id) {
        return groupRepository.findWithMembersById(id)
                .map(GroupDetailResponseDto::from)
                .orElseThrow(() -> new ResourceNotFoundException("Group", id));
    }
}