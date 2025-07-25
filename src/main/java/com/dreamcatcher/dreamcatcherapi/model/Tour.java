package com.dreamcatcher.dreamcatcherapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "tours")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Tour extends ImageGenerable {
    @Id
    private Long id;
    private String title;
    private String startDate;
    private String endDate;
    private int year;
    private int setShows;
    private List<Show> shows;
    private String image;

    @Override
    public void generateImageUrl() {
        if (id == null) {
            image = null;
            return;
        }
        image = "https://dreamcatcherapi.onrender.com/images/tours/tour" + id + ".png";
    }

    @Override
    public String getImage() {
        return image;
    }
}
