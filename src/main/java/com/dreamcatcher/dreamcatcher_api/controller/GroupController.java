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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
@Tag(name = "Groups", description = "K-pop groups")
public class GroupController {

    private final GroupService groupService;
    private final AlbumService albumService;
    private final IdolService idolService;

    @GetMapping
    @Operation(summary = "List all groups")
    public List<GroupResponseDto> getAllGroups() {
        return groupService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a group by id")
    public GroupDetailResponseDto getGroupById(@PathVariable Long id) {
        return groupService.findById(id);
    }

    @GetMapping("/{groupId}/albums")
    @Operation(summary = "List the albums of a group")
    public List<AlbumResponseDto> getAlbumsByGroupId(@PathVariable Long groupId) {
        return albumService.findAllByGroupId(groupId);
    }

    @GetMapping("/{groupId}/idols")
    @Operation(summary = "List the members (idols) of a group")
    public List<IdolResponseDto> getIdolsByGroupId(@PathVariable Long groupId) {
        return idolService.findAllByGroupId(groupId);
    }
}