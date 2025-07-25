package com.dreamcatcher.dreamcatcherapi.mappers;

import com.dreamcatcher.dreamcatcherapi.dtos.ShowDto;
import com.dreamcatcher.dreamcatcherapi.dtos.TourDetailDto;
import com.dreamcatcher.dreamcatcherapi.dtos.TourDto;
import com.dreamcatcher.dreamcatcherapi.model.Show;
import com.dreamcatcher.dreamcatcherapi.model.Tour;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface TourMapper {

    @Mapping(target = "image", source = "image")
    TourDto toDTO(Tour tour);

    @Mapping(target = "image", source = "image")
    @Mapping(target = "shows", source = "shows")
    TourDetailDto toDetailDTO(Tour tour);

    ShowDto toShowDto(Show show);
}
