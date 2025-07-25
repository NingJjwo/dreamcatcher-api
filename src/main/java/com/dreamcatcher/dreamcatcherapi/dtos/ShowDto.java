package com.dreamcatcher.dreamcatcherapi.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowDto {
    private Long id;
    private String date;
    private String country;
    private String city;
    private String venue;
}
