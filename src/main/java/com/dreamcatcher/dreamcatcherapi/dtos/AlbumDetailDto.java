package com.dreamcatcher.dreamcatcherapi.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AlbumDetailDto {
    private long id;
    private String title;
    private int tracks;
    private String releaseDate;
    private List<SongDto> songs;
    private String image;
}