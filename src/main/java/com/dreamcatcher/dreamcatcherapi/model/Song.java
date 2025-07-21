package com.dreamcatcher.dreamcatcherapi.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Song {
    private long id;
    private String title;

    public Song() {}

    public Song(long id, String title) {
        this.id = id;
        this.title = title;
    }




}
