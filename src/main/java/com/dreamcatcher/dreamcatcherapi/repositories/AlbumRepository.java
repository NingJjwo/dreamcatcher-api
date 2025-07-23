package com.dreamcatcher.dreamcatcherapi.repositories;

import com.dreamcatcher.dreamcatcherapi.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository extends MongoRepository<Album, Long> {
    List<Album> findAll();
    Optional<Album> findByTitle(String title);
    List<Album> findByYear(int year);
    List<Album> findByReleasedAs(String releasedAs);
}
