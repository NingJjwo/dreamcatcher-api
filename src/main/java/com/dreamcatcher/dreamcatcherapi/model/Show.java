package com.dreamcatcher.dreamcatcherapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show {
    @Id
    private Long id;
    private String date;
    private String country;
    private String city;
    private String venue;
}