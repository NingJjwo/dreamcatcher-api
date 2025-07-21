package com.dreamcatcher.dreamcatcherapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "albums")
public class Album {
    @Id
    private long id;
    private String releasedAs;
    private String title;
    private int tracks;
    private int year;
    private String releaseDate;
    private List<Song> songs;

    public Album() {
    }

    public Album(long id, String releasedAs, String title, int tracks, int year, String releaseDate, List<Song> songs) {
        this.id = id;
        this.releasedAs = releasedAs;
        this.title = title;
        this.tracks = tracks;
        this.year = year;
        this.releaseDate = releaseDate;
        this.songs = songs;
    }
}
