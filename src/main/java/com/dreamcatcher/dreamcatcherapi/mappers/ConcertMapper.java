package com.dreamcatcher.dreamcatcherapi.mappers;

import com.dreamcatcher.dreamcatcherapi.dtos.ConcertDetailDto;
import com.dreamcatcher.dreamcatcherapi.dtos.ConcertDto;
import com.dreamcatcher.dreamcatcherapi.dtos.ShowDto;
import com.dreamcatcher.dreamcatcherapi.model.Concert;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ConcertMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "totalShows", source = "totalShows")
    ConcertDto toDTO(Concert concert);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "image", source = "image")
    @Mapping(target = "shows", source = "shows", qualifiedByName = "mapShowsToShowDtos")
    ConcertDetailDto toDetailDTO(Concert concert);

    @Named("mapShowsToShowDtos")
    default List<ShowDto> mapShowsToShowDtos(List<com.dreamcatcher.dreamcatcherapi.model.Show> shows) {
        return shows != null ? shows.stream()
                .map(show -> {
                    ShowDto showDto = new ShowDto();
                    showDto.setId(show.getId());
                    showDto.setDate(show.getDate());
                    showDto.setCountry(show.getCountry());
                    showDto.setCity(show.getCity());
                    showDto.setVenue(show.getVenue());
                    return showDto;
                })
                .collect(Collectors.toList()) : List.of();
    }
}
