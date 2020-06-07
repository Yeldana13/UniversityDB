package com.example.sweater.domain;

import org.hibernate.annotations.Type;
import org.hibernate.type.StringType;
import javax.persistence.*;
@Entity
@Table(name="basic")
public class Basic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "speciality")
    private String speciality;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "university" )
    private String university;
    @Column(name = "universityId")
    private String university_id;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "number")
    private String number;
    @Column(name = "url")
    private String url;
    //@JoinTable(name="users",joinColumns = @JoinColumn(name=""))
    public Basic() {
    }

    public Basic(String speciality, String name, String university, String university_id, String city, String street, String number, String url) {
        this.speciality = speciality;
        this.name = name;
        this.university = university;
        this.university_id = university_id;
        this.city = city;
        this.street = street;
        this.number = number;
        this.url = url;
    }

    public String getId_speciality() {
        return speciality;
    }

    public void setId_speciality(String id_speciality) {
        this.speciality = id_speciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(String university_id) {
        this.university_id = university_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
