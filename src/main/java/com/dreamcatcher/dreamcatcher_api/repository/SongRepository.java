package com.dreamcatcher.dreamcatcher_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dreamcatcher.dreamcatcher_api.model.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByAlbumAlbumId(Long albumId);
}
