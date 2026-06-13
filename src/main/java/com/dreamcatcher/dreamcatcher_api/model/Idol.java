package com.dreamcatcher.dreamcatcher_api.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "idols", schema = "api")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Idol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idol_id")
    private Long idolId;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "stage_name")
    private String stageName;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany
    @JoinTable(name = "idol_positions", schema = "api", joinColumns = @JoinColumn(name = "idol_id"), inverseJoinColumns = @JoinColumn(name = "position_id"))
    @BatchSize(size = 50)
    private Set<Position> positions = new HashSet<>();

    @Column(name = "lore_concept")
    private String loreConcept;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;
}
