package com.example.sweater.domain;

import javax.persistence.*;

@Entity
@Table(name="profession")
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "key")
    private String key;
    @Column(name = "speciality" )
    private String speciality;
    @Column(name = "prof")
    private String prof;

    public Profession(String key, String speciality, String profession) {
        this.key = key;
        this.speciality = speciality;
        this.prof = profession;
    }

    public Profession() {
    }

    public Profession(String key, String speciality) {
        this.key = key;
        this.speciality = speciality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getProf() {
        return prof;
    }
}
