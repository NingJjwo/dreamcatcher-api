package com.dreamcatcher.dreamcatcher_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dreamcatcher.dreamcatcher_api.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByGroupGroupId(Long groupId);
}
