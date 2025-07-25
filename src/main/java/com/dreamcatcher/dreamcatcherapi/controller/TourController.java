package com.dreamcatcher.dreamcatcherapi.controller;

import com.dreamcatcher.dreamcatcherapi.dtos.TourDetailDto;
import com.dreamcatcher.dreamcatcherapi.dtos.TourDto;
import com.dreamcatcher.dreamcatcherapi.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tours")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping
    public ResponseEntity<List<TourDto>> getAllTours() {
        List<TourDto> dtos = tourService.getAllToursDto();
        return dtos.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(dtos);
    }

    @GetMapping("/title")
    public ResponseEntity<TourDetailDto> getTourByTitle(@RequestParam(required = false) String title) {
        tourService.validateTourTitle(title);
        return ResponseEntity.ok(tourService.getTourDetailDto(title));
    }
}