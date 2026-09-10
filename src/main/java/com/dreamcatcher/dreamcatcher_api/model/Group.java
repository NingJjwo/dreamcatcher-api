package com.dreamcatcher.dreamcatcher_api.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"groups\"", schema = "api")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "agency_name")
    private String agencyName;

    @Column(name = "concept")
    private String concept;

    @Column(name = "group_image")
    private String groupImage;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private final List<Idol>  idols =  new ArrayList<>();

    public List<Idol> getIdols(){
        return Collections.unmodifiableList(this.idols);
    }
}
