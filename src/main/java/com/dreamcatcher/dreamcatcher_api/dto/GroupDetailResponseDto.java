package com.dreamcatcher.dreamcatcher_api.dto;

import java.util.List;

import com.dreamcatcher.dreamcatcher_api.model.Group;
import com.dreamcatcher.dreamcatcher_api.util.AssetUrl;

public record GroupDetailResponseDto(
        Long id,
        String groupName,
        String agencyName,
        String concept,
        String groupImage,
        List<IdolResponseDto> members) {

    public static GroupDetailResponseDto from(Group group, String assetBaseUrl) {
        return new GroupDetailResponseDto(
                group.getId(),
                group.getGroupName(),
                group.getAgencyName(),
                group.getConcept(),
                AssetUrl.resolve(assetBaseUrl, group.getGroupImage()),
                group.getIdols().stream().map(idol -> IdolResponseDto.from(idol, assetBaseUrl)).toList());
    }
}