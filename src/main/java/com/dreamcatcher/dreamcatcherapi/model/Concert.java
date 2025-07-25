package com.dreamcatcher.dreamcatcherapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "concerts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Concert extends ImageGenerable {
    @Id
    private Long id;
    private String title;
    private int year;
    private String startDate;
    private String endDate;
    private int totalShows;
    private List<Show> shows;
    private String image;

    @Override
    public void generateImageUrl() {
        if (title == null || year <= 0) {
            image = null;
            return;
        }
        try {
            String baseTitle = title.contains("(")
                    ? title.substring(0, title.indexOf("(")).trim()
                    : title.trim();
            baseTitle = baseTitle.replaceAll("[^a-zA-Z0-9\\s-]", "-")
                    .replaceAll("\\s+", "-")
                    .replaceAll("-+", "-");

            String tempBaseTitle = baseTitle.substring(0, Math.min(20, baseTitle.length())) + "-" + year;
            if (tempBaseTitle.equals("Luck-Inside-7-Doors--2024")) {
                baseTitle = baseTitle.substring(0, Math.min(17, baseTitle.length())) + "-" + id + "-" + year;
            } else {
                baseTitle = baseTitle.substring(0, Math.min(20, baseTitle.length())) + "-" + year;
            }
            image = "https://dreamcatcherapi.onrender.com/images/concerts/" + baseTitle + ".jpeg";
        } catch (Exception e) {
            image = null;
        }
    }

    @Override
    public String getImage() {
        return image;
    }
}

