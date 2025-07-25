package com.dreamcatcher.dreamcatcherapi.controller;

import com.dreamcatcher.dreamcatcherapi.dtos.ConcertDetailDto;
import com.dreamcatcher.dreamcatcherapi.dtos.ConcertDto;
import com.dreamcatcher.dreamcatcherapi.mappers.ConcertMapper;
import com.dreamcatcher.dreamcatcherapi.model.Concert;
import com.dreamcatcher.dreamcatcherapi.repositories.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/concerts")
public class ConcertController {

    @Autowired
    private ConcertRepository concertRepository;
    @Autowired
    private ConcertMapper concertMapper;

    @GetMapping
    public ResponseEntity<List<ConcertDto>> getAllConcerts() {
        List<ConcertDto> concerts = concertRepository.findAll()
                .stream()
                .peek(Concert::generateImageUrl)
                .map(concertMapper::toDTO)
                .collect(Collectors.toList());
        return concerts.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(concerts);
    }

    @GetMapping("/getConcertDetails")
    public ResponseEntity<ConcertDetailDto> getConcertByTitle(@RequestParam String title) {
        Optional<Concert> concertOptional = concertRepository.findByTitleContaining(title);
        return concertOptional.map(concert -> {
            concert.generateImageUrl();
            ConcertDetailDto concertDto = concertMapper.toDetailDTO(concert);
            return ResponseEntity.ok(concertDto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}