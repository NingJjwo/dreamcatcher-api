package com.dreamcatcher.dreamcatcher_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dreamcatcher.dreamcatcher_api.dto.IdolResponseDto;
import com.dreamcatcher.dreamcatcher_api.service.IdolService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/idols")
@RequiredArgsConstructor
@Tag(name = "Idols", description = "K-pop idols and members")
public class IdolController {

    private final IdolService idolService;

    @GetMapping
    @Operation(summary = "List all idols, optionally filtered by name")
    public List<IdolResponseDto> getAllIdols(
            @Parameter(description = "Filter by partial stage name")
            @RequestParam(name = "name", required = false) String name) {
        return idolService.findAll(name);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an idol by id")
    public IdolResponseDto getIdolById(@PathVariable Long id) {
        return idolService.findById(id);
    }
}