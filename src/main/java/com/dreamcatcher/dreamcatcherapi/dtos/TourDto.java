package com.dreamcatcher.dreamcatcherapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourDto {
    private Long id;
    private String title;
    @JsonIgnore
    private int year;
    private int setShows;
    private String image;
}
