package com.dreamcatcher.dreamcatcher_api.dto;

import com.dreamcatcher.dreamcatcher_api.model.Album;
import com.dreamcatcher.dreamcatcher_api.util.AssetUrl;

public record AlbumResponseDto(
        Long id,
        String albumTitle,
        Integer trackCount,
        Integer releaseDate,
        String albumType,
        String albumImage) {

    public static AlbumResponseDto from(Album album, String assetBaseUrl) {
        return new AlbumResponseDto(
                album.getId(),
                album.getAlbumTitle(),
                album.getTrackCount(),
                album.getReleaseDate(),
                album.getAlbumType(),
                AssetUrl.resolve(assetBaseUrl, album.getAlbumImage()));
    }
}