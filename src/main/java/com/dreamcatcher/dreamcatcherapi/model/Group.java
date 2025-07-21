package com.dreamcatcher.dreamcatcherapi.model;

import lombok.Data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "dreamcatcher")


public class Group {
    @Id
    private long id;
    private String name;
    private String formationDate;
    private String company;
    private String description;
    private List<String> members;

    public Group() {}
    public Group(long id, String name, String formationDate, String company, String description, List<String> members) {
        this.id = id;
        this.name = name;
        this.formationDate = formationDate;
        this.company = company;
        this.description = description;
        this.members = members;
    }

}
