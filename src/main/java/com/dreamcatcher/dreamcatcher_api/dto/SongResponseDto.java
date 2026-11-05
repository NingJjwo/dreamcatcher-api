package com.dreamcatcher.dreamcatcher_api.dto;

import com.dreamcatcher.dreamcatcher_api.model.Song;

public record SongResponseDto(
        Long id,
        String songName,
        Integer trackNumber) {

    public static SongResponseDto from(Song song) {
        return new SongResponseDto(
                song.getId(),
                song.getSongName(),
                song.getTrackNumber());
    }
}
