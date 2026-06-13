package com.dreamcatcher.dreamcatcher_api.dto;

import com.dreamcatcher.dreamcatcher_api.model.Album;

public record AlbumResponseDto(
        Long id,
        Long albumId,
        String albumTitle,
        Integer trackCount,
        Integer releaseDate,
        String albumType,
        String albumImage) {

    public static AlbumResponseDto from(Album album) {
        if (album == null) {
            return null;
        }
        return new AlbumResponseDto(
                album.getAlbumId(),
                album.getAlbumId(),
                album.getAlbumTitle(),
                album.getTrackCount(),
                album.getReleaseDate(),
                album.getAlbumType(),
                album.getAlbumImage());
    }
}
