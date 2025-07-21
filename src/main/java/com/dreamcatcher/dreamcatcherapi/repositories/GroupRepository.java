package com.dreamcatcher.dreamcatcherapi.repositories;

import com.dreamcatcher.dreamcatcherapi.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface GroupRepository extends MongoRepository<Group, String> {
    Optional<Group> findByName(String dreamcatcher);
}