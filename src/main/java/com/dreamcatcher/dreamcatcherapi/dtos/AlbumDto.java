package com.dreamcatcher.dreamcatcherapi.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AlbumDto {
    private long id;
    private String title;
    private int tracks;
    private String releaseDate;
    private String image;
}
