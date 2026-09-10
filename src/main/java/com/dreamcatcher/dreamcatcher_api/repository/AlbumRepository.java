package com.dreamcatcher.dreamcatcher_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dreamcatcher.dreamcatcher_api.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByGroup_Id(Long groupId);
}
