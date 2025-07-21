package com.dreamcatcher.dreamcatcherapi.model;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Document(collection = "members")
public class Member {

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

    public Member(Long id, String realName, String stageName, String koreanName, String role, String dateBorn, String nationality, String cityBorn, String nightmare) {
        this.id = id;
        this.realName = realName;
        this.stageName = stageName;
        this.koreanName = koreanName;
        this.role = role;
        this.dateBorn = dateBorn;
        this.nationality = nationality;
        this.cityBorn = cityBorn;
        this.nightmare = nightmare;
    }

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return id;
    }

    public void setRealName(String realName){
        this.realName = realName;
    }
    public String getRealName() {
        return realName;
    }

    public void setStageName(String stageName){
        this.stageName = stageName;
    }
    public String getStageName() {
        return stageName;
    }

    public void setKoreanName(String koreanName){
        this.koreanName = koreanName;
    }
    public String getKoreanName() {
        return koreanName;
    }

    public void setRole(String role){
        this.role = role;
    }
    public String getRole() {
        return role;
    }

    public void setDateBorn(String dateBorn){
        this.dateBorn = dateBorn;
    }
    public String getDateBorn() {
        return dateBorn;
    }

    public void setNationality(String nationality){
        this.nationality = nationality;
    }
    public String getNationality() {
        return nationality;
    }

    public void setCityBorn(String cityBorn){
        this.cityBorn = cityBorn;
    }
    public String getCityBorn() {
        return cityBorn;
    }

    public void setNightmare(String nightmare){
        this.nightmare = nightmare;
    }
    public String getNightmare(){
        return nightmare;
    }

}