package com.dreamcatcher.dreamcatcherapi.service;

import com.dreamcatcher.dreamcatcherapi.dtos.ConcertDto;
import com.dreamcatcher.dreamcatcherapi.exception.DreamcatcherException;
import com.dreamcatcher.dreamcatcherapi.mappers.ConcertMapper;
import com.dreamcatcher.dreamcatcherapi.model.Concert;
import com.dreamcatcher.dreamcatcherapi.repositories.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConcertService {

    @Autowired
    private ConcertRepository concertRepository;

    @Autowired
    private ConcertMapper concertMapper;

    public List<ConcertDto> getAllConcertsDto() {
        List<Concert> concerts = concertRepository.findAll();
        concerts.forEach(Concert::generateImageUrl);
        return concerts.stream().map(concertMapper::toDTO).collect(Collectors.toList());
    }

    public ConcertDto getConcertDto(String title) {
        Concert concert = concertRepository.findByTitleContaining(title)
                .orElseThrow(() -> new DreamcatcherException(404, "No concert found containing " + title));
        concert.generateImageUrl();
        return concertMapper.toDTO(concert);
    }
}
