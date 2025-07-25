package com.dreamcatcher.dreamcatcherapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "albums")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Album extends ImageGenerable {
    @Id
    private Long id;
    private String releasedAs;
    private String title;
    private int tracks;
    private int year;
    private String releaseDate;
    private List<Song> songs;
    private String image;

    @Override
    public void generateImageUrl() {
        if (title == null || year <= 0) {
            image = null;
            return;
        }
        try {
            String baseTitle = title.contains("(")
                    ? title.substring(0, title.indexOf("(")).trim() : title.trim();
            baseTitle = baseTitle.replaceAll("[^a-zA-Z0-9\\s-]", "-")
                    .replaceAll("\\s+", "-")
                    .replaceAll("-+", "-");

            if (baseTitle.length() > 20) {
                baseTitle = baseTitle.substring(0, 20);
            }
            baseTitle += "-" + year;
            image = "https://dreamcatcherapi.onrender.com/images/albums/" + baseTitle + ".jpeg";
        } catch (Exception e) {
            image = null;
        }
    }

    @Override
    public String getImage() {
        return image;
    }
}
