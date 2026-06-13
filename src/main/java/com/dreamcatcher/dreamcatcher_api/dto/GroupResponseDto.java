package com.dreamcatcher.dreamcatcher_api.dto;

import com.dreamcatcher.dreamcatcher_api.model.Group;

public record GroupResponseDto(
        Long groupId,
        String groupName,
        String agencyName,
        String concept,
        String groupImage) {
    public static GroupResponseDto from(Group group) {
        if (group == null) {
            return null;
        }
        return new GroupResponseDto(
                group.getGroupId(),
                group.getGroupName(),
                group.getAgencyName(),
                group.getConcept(),
                group.getGroupImage());
    }
}
