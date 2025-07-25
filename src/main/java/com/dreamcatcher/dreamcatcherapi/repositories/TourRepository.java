package com.dreamcatcher.dreamcatcherapi.repositories;

import com.dreamcatcher.dreamcatcherapi.model.Tour;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TourRepository extends MongoRepository<Tour, Long> {
    Optional<Tour> findByTitleContaining(String title);
}
