package com.dreamcatcher.dreamcatcher_api.dto;

import java.util.List;

import com.dreamcatcher.dreamcatcher_api.model.Idol;
import com.dreamcatcher.dreamcatcher_api.model.Position;
import com.dreamcatcher.dreamcatcher_api.util.AssetUrl;

public record IdolResponseDto(
        Long id,
        String stageName,
        String realName,
        String nationality,
        String loreConcept,
        String imageUrl,
        String groupName,
        List<String> positions) {

    public static IdolResponseDto from(Idol idol, AssetUrl assetUrl) {
        List<String> positionNames = idol.getPositions().stream().map(Position::getName).toList();

        return new IdolResponseDto(
                idol.getId(),
                idol.getStageName(),
                idol.getRealName(),
                idol.getNationality(),
                idol.getLoreConcept(),
                assetUrl.resolve(idol.getImageUrl()),
                idol.getGroup() != null ? idol.getGroup().getGroupName() : null,
                positionNames);
    }
}
