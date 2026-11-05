package com.dreamcatcher.dreamcatcher_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.dreamcatcher.dreamcatcher_api.dto.IdolResponseDto;
import com.dreamcatcher.dreamcatcher_api.service.IdolService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/idols")
@RequiredArgsConstructor
@Tag(name = "Idols", description = "K-pop idols and members")
public class IdolController {

    private final IdolService idolService;

    @GetMapping
    @Operation(summary = "List all idols")
    public List<IdolResponseDto> getAllIdols() {
        return idolService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an idol by id")
    public IdolResponseDto getIdolById(@PathVariable Long id) {
        return idolService.findById(id);
    }

    @GetMapping("/group/{id}")
    @Operation(summary = "List the members (idols) of a group")
    public List<IdolResponseDto> getIdolsByGroupId(@PathVariable Long id) {
        return idolService.findAllByGroupId(id);
    }

}
