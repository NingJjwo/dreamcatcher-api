package com.dreamcatcher.dreamcatcher_api.dto;

import java.util.List;

import com.dreamcatcher.dreamcatcher_api.model.Idol;
import com.dreamcatcher.dreamcatcher_api.model.Position;

public record IdolResponseDto(
        Long id,
        String stageName,
        String realName,
        String nationality,
        String loreConcept,
        String imageUrl,
        List<String> positions) {

    public static IdolResponseDto from(Idol idol) {
        if (idol == null) {
            return null;
        }

        List<String> positionNames = idol.getPositions() != null
                ? idol.getPositions().stream().map(Position::getName).toList()
                : List.of();

        return new IdolResponseDto(
                idol.getId(),
                idol.getStageName(),
                idol.getRealName(),
                idol.getNationality(),
                idol.getLoreConcept(),
                idol.getImageUrl(),
                positionNames);
    }
}
