package com.dreamcatcher.dreamcatcherapi.mappers;

import com.dreamcatcher.dreamcatcherapi.dtos.AlbumDetailDto;
import com.dreamcatcher.dreamcatcherapi.dtos.AlbumDto;
import com.dreamcatcher.dreamcatcherapi.dtos.SongDto;
import com.dreamcatcher.dreamcatcherapi.model.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "tracks", source = "tracks")
    @Mapping(target = "releaseDate", source = "releaseDate")
    AlbumDto toDTO(Album album);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "tracks", source = "tracks")
    @Mapping(target = "releaseDate", source = "releaseDate")
    @Mapping(target = "songs", source = "songs", qualifiedByName = "mapSongsToSongDtos")
    AlbumDetailDto toDetailDTO(Album album);

    @Named("mapSongsToSongDtos")
    default List<SongDto> mapSongsToSongDtos(List<com.dreamcatcher.dreamcatcherapi.model.Song> songs) {
        return songs != null ? songs.stream()
                .map(song -> {
                    SongDto songDto = new SongDto();
                    songDto.setId(song.getId());
                    songDto.setTitle(song.getTitle());
                    return songDto;
                })
                .collect(Collectors.toList()) : List.of();
    }
}