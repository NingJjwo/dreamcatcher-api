package com.dreamcatcher.dreamcatcherapi.service;

import com.dreamcatcher.dreamcatcherapi.dtos.TourDetailDto;
import com.dreamcatcher.dreamcatcherapi.dtos.TourDto;
import com.dreamcatcher.dreamcatcherapi.exception.DreamcatcherException;
import com.dreamcatcher.dreamcatcherapi.mappers.TourMapper;
import com.dreamcatcher.dreamcatcherapi.model.Tour;
import com.dreamcatcher.dreamcatcherapi.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private TourMapper tourMapper;

    public void generateImageUrl(Tour tour) {
        if (tour != null) {
            tour.generateImageUrl();
            if (tour.getImage() == null) {
                throw new DreamcatcherException(400, "Failed to generate image URL for tour");
            }
        }
    }

    public void validateTourTitle(String tourTitle) {
        if (tourTitle == null || tourTitle.trim().isEmpty()) {
            throw new DreamcatcherException(400, "Please provide a tour title or part of it");
        }
    }

    public List<TourDto> getAllToursDto() {
        List<Tour> tours = tourRepository.findAll();
        tours.forEach(this::generateImageUrl);
        return tours.stream().map(tourMapper::toDTO).collect(Collectors.toList());
    }

    public TourDetailDto getTourDetailDto(String tourTitle) {
        Tour tour = tourRepository.findByTitleContaining(tourTitle)
                .orElseThrow(() -> new DreamcatcherException(404, "No tour found containing " + tourTitle));
        generateImageUrl(tour);
        return tourMapper.toDetailDTO(tour);
    }
}
