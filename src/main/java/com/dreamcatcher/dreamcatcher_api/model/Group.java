package com.dreamcatcher.dreamcatcher_api.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "\"groups\"", schema = "api")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "agency_name")
    private String agencyName;

    @Column(name = "concept")
    private String concept;

    @Column(name = "group_image")
    private String groupImage;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Idol> idols;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Album> albums;
}
