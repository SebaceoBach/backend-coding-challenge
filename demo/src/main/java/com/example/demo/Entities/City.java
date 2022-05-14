package com.example.demo.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "city_details")
public class City implements Serializable{

    
    public City() {
        super();
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "ascii")
    private String ascii;
    @Column(name = "alt_name")
    private String altName;
    @Column(name = "lat")
    private String lat;
    @Column(name = "long")
    private String longi;
    @Column(name = "feat_class")
    private String featClass;
    @Column(name = "feat_code")
    private String featCode;
    @Column(name = "country")
    private String country;
    @Column(name = "cc2")
    private String cc2;
    @Column(name = "admin1")
    private String admin1;
    @Column(name = "admin2")
    private String admin2;
    @Column(name = "admin3")
    private String admin3;
    @Column(name = "admin4")
    private String admin4;
    @Column(name = "population")
    private String population;
    @Column(name = "elevation")
    private String elevation;
    @Column(name = "dem")
    private String dem;
    @Column(name = "tz")
    private String tz;
    @Column(name = "modified_at")
    private String modifiedAt;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAscii() {
        return ascii;
    }
    public void setAscii(String ascii) {
        this.ascii = ascii;
    }
    public String getAltName() {
        return altName;
    }
    public void setAltName(String altName) {
        this.altName = altName;
    }
    public String getLat() {
        return lat;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getLongi() {
        return longi;
    }
    public void setLongi(String longi) {
        this.longi = longi;
    }
    public String getFeatClass() {
        return featClass;
    }
    public void setFeatClass(String featClass) {
        this.featClass = featClass;
    }
    public String getFeatCode() {
        return featCode;
    }
    public void setFeatCode(String featCode) {
        this.featCode = featCode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCc2() {
        return cc2;
    }
    public void setCc2(String cc2) {
        this.cc2 = cc2;
    }
    public String getAdmin1() {
        return admin1;
    }
    public void setAdmin1(String admin1) {
        this.admin1 = admin1;
    }
    public String getAdmin2() {
        return admin2;
    }
    public void setAdmin2(String admin2) {
        this.admin2 = admin2;
    }
    public String getAdmin3() {
        return admin3;
    }
    public void setAdmin3(String admin3) {
        this.admin3 = admin3;
    }
    public String getAdmin4() {
        return admin4;
    }
    public void setAdmin4(String admin4) {
        this.admin4 = admin4;
    }
    public String getPopulation() {
        return population;
    }
    public void setPopulation(String population) {
        this.population = population;
    }
    public String getElevation() {
        return elevation;
    }
    public void setElevation(String elevation) {
        this.elevation = elevation;
    }
    public String getDem() {
        return dem;
    }
    public void setDem(String dem) {
        this.dem = dem;
    }
    public String getTz() {
        return tz;
    }
    public void setTz(String tz) {
        this.tz = tz;
    }
    public String getModifiedAt() {
        return modifiedAt;
    }
    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
    
    
    
}
