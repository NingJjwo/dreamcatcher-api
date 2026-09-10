package com.dreamcatcher.dreamcatcher_api.model;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "albums", schema = "api", indexes = {
        @Index(name = "idx_albums_title", columnList = "album_title")
})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "album_title")
    private String albumTitle;

    @Column(name = "track_count")
    private Integer trackCount;

    @Column(name = "release_date")
    private Integer releaseDate;

    @Column(name = "album_type")
    private String albumType;

    @Column(name = "album_image")
    private String albumImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;
}
