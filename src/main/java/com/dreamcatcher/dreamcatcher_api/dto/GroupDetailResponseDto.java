package com.dreamcatcher.dreamcatcher_api.dto;

import java.util.List;

import com.dreamcatcher.dreamcatcher_api.model.Group;

public record GroupDetailResponseDto(
        Long id,
        String groupName,
        String agencyName,
        String concept,
        String groupImage,
        List<IdolResponseDto> members) {

    public static GroupDetailResponseDto from(Group group) {
        return new GroupDetailResponseDto(
                group.getId(),
                group.getGroupName(),
                group.getAgencyName(),
                group.getConcept(),
                group.getGroupImage(),
                group.getIdols().stream().map(IdolResponseDto::from).toList());
    }
}