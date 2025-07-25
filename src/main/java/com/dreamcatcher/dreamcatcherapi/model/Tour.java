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
        if (title == null || year <= 0) {
            image = null;
            return;
        }
        try {

            String base = title.contains("(")
                    ? title.substring(0, title.indexOf("(")).trim()
                    : title.trim();

            base = base.toLowerCase()
                    .replaceAll("[^a-z0-9]", "-")
                    .replaceAll("-+", "-")
                    .replaceAll("^-|-$", "");

            if (base.length() > 15) base = base.substring(0, 15).replaceAll("-$", "");
            if (base.isEmpty()) base = "tour";

            image = "https://dreamcatcherapi.onrender.com/images/tours/" + base + "-" + year + "-" + this.id + ".png";

        } catch (Exception e) {
            image = null;
            System.out.println("Error generating image URL: " + e.getMessage());
        }
    }

    @Override
    public String getImage() {
        return image;
    }
}
