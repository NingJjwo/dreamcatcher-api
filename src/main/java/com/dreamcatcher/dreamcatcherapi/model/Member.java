package com.dreamcatcher.dreamcatcherapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Setter
@Getter
@Document(collection = "members")
public class Member extends ImageGenerable {

    @Id
    private Long id;
    private String realName;
    private String stageName;
    private String koreanName;
    private String role;
    private String dateBorn;
    private String nationality;
    private String cityBorn;
    private String nightmare;
    private String image;

    public Member(Long id, String realName, String stageName, String koreanName, String role, String dateBorn, String nationality, String cityBorn, String nightmare,
                  String image) {
        this.id = id;
        this.realName = realName;
        this.stageName = stageName;
        this.koreanName = koreanName;
        this.role = role;
        this.dateBorn = dateBorn;
        this.nationality = nationality;
        this.cityBorn = cityBorn;
        this.nightmare = nightmare;
        this.image = image;
    }

    @Override
    public void generateImageUrl() {
        if (stageName != null) {
            try {
                String safeStageName = stageName.toLowerCase();
                image = "https://dreamcatcherapi.onrender.com/images/members/" + safeStageName + ".png";
            } catch (Exception e) {
                image = null;
            }
        }
    }

    @Override
    public String getImage() {
        return image;
    }
}