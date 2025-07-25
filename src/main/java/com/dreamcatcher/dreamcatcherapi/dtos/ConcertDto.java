package com.dreamcatcher.dreamcatcherapi.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ConcertDto {
    private long id;
    private String title;
    private int totalShows;
    private String image;
}
