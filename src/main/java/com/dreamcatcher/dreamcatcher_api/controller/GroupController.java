package com.dreamcatcher.dreamcatcher_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamcatcher.dreamcatcher_api.dto.AlbumResponseDto;
import com.dreamcatcher.dreamcatcher_api.dto.GroupDetailResponseDto;
import com.dreamcatcher.dreamcatcher_api.dto.GroupResponseDto;
import com.dreamcatcher.dreamcatcher_api.dto.IdolResponseDto;
import com.dreamcatcher.dreamcatcher_api.service.AlbumService;
import com.dreamcatcher.dreamcatcher_api.service.GroupService;
import com.dreamcatcher.dreamcatcher_api.service.IdolService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;
    private final AlbumService albumService;
    private final IdolService idolService;

    @GetMapping
    public List<GroupResponseDto> getAllGroups() {
        return groupService.findAll();
    }

    @GetMapping("/{id}")
    public GroupDetailResponseDto getGroupById(@PathVariable Long id) {
        return groupService.findById(id);
    }

    @GetMapping("/{groupId}/albums")
    public List<AlbumResponseDto> getAlbumsByGroupId(@PathVariable Long groupId) {
        return albumService.findAllByGroupId(groupId);
    }

    @GetMapping("/{groupId}/idols")
    public List<IdolResponseDto> getIdolsByGroupId(@PathVariable Long groupId) {
        return idolService.findAllByGroupId(groupId);
    }
}