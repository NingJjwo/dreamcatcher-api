package com.dreamcatcher.dreamcatcher_api.dto;

import com.dreamcatcher.dreamcatcher_api.model.Group;
import com.dreamcatcher.dreamcatcher_api.util.AssetUrl;

public record GroupResponseDto(
        Long id,
        String groupName,
        String agencyName,
        String concept,
        String groupImage) {
    public static GroupResponseDto from(Group group, AssetUrl assetUrl) {
        return new GroupResponseDto(
                group.getId(),
                group.getGroupName(),
                group.getAgencyName(),
                group.getConcept(),
                assetUrl.resolve(group.getGroupImage()));
    }
}
