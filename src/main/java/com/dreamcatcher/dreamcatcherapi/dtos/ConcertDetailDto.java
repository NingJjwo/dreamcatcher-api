package com.dreamcatcher.dreamcatcherapi.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ConcertDetailDto {
    private long id;
    private String title;
    private String image;
    private List<ShowDto> shows;
}
