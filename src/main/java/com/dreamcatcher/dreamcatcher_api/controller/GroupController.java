package com.dreamcatcher.dreamcatcher_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamcatcher.dreamcatcher_api.dto.GroupDetailResponseDto;
import com.dreamcatcher.dreamcatcher_api.dto.GroupResponseDto;
import com.dreamcatcher.dreamcatcher_api.service.GroupService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public List<GroupResponseDto> getAllGroups() {
        return groupService.findAll();
    }

    @GetMapping("/{id}")
    public GroupDetailResponseDto getGroupById(@PathVariable Long id) {
        return groupService.findById(id);
    }
}