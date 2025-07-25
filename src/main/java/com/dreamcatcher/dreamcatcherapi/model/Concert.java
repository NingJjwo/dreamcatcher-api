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
        if (id == null) {
            image = null;
            return;
        }
        image = "https://dreamcatcherapi.onrender.com/images/concerts/concert" + id + ".jpeg";
    }

    @Override
    public String getImage() {
        return image;
    }
}

