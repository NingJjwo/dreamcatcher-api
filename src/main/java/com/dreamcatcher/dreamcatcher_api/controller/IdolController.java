package com.dreamcatcher.dreamcatcher_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dreamcatcher.dreamcatcher_api.dto.IdolResponseDto;
import com.dreamcatcher.dreamcatcher_api.service.IdolService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/idols")
@RequiredArgsConstructor
public class IdolController {

    private final IdolService idolService;

    @GetMapping
    public List<IdolResponseDto> getAllIdols(
            @RequestParam(name = "name", required = false) String name) {
        return idolService.findAll(name);
    }

    @GetMapping("/{id}")
    public IdolResponseDto getIdolById(@PathVariable Long id) {
        return idolService.findById(id);
    }
}