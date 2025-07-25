package com.dreamcatcher.dreamcatcherapi.repositories;

import com.dreamcatcher.dreamcatcherapi.model.Concert;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ConcertRepository extends MongoRepository<Concert, Long> {
    Optional<Concert> findByTitleContaining(String title);
}