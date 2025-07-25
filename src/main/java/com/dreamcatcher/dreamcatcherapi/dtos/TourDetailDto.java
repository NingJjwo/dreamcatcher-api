package com.dreamcatcher.dreamcatcherapi.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourDetailDto {
    private String image;
    private String tourTitle;
    private String startDate;
    private String endDate;
    private List<ShowDto> shows;
}
