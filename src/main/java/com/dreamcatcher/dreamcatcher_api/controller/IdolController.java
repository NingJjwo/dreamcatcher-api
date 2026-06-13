package com.dreamcatcher.dreamcatcher_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.dreamcatcher.dreamcatcher_api.dto.IdolResponseDto;
import com.dreamcatcher.dreamcatcher_api.service.IdolService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class IdolController {

    private final IdolService idolService;

    @GetMapping("/api/idols")
    public ResponseEntity<List<IdolResponseDto>> getAllIdols() {
        return ResponseEntity.ok(idolService.findAll());
    }

    @GetMapping("/api/idols/search")
    public ResponseEntity<List<IdolResponseDto>> searchIdolsByStageName(@RequestParam String name) {
        return ResponseEntity.ok(idolService.findByStageName(name));
    }

    @GetMapping("/api/idols/{id}")
    public ResponseEntity<IdolResponseDto> getIdolById(@PathVariable Long id) {
        return ResponseEntity.ok(idolService.findById(id));
    }

    @GetMapping("/api/groups/members/{groupId}")
    public ResponseEntity<List<IdolResponseDto>> getMembersByGroup(@PathVariable Long groupId) {
        return ResponseEntity.ok(idolService.findAllByGroupId(groupId));
    }
}