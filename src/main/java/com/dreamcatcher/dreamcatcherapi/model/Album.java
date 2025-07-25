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
        if (id == null) {
            image = null;
            return;
        }
        image = "https://dreamcatcherapi.onrender.com/images/albums/album" + id + ".jpeg";
    }

    @Override
    public String getImage() {
        return image;
    }
}
