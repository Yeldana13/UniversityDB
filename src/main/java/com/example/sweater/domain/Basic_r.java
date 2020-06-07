package com.example.sweater.domain;

import javax.persistence.*;

@Entity
//@JoinTable(name="basic",joinColumns = "speciality_id")
@Table(name="basic_r")
public class Basic_r {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name="speciality_id")
    private String speciality_id;
    @Column(name="speciality_name")
    private String name;
    @Column(name="prof1")
    private String prof1;
    @Column(name="prof2")
    private String prof2;

    //

    public Basic_r(){
    }

    public Basic_r(int id, String speciality_id, String name, String prof1, String prof2) {
        this.id = id;
        this.speciality_id = speciality_id;
        this.name = name;
        this.prof1 = prof1;
        this.prof2 = prof2;
    }

    public String getSpeciality_id(){
        return speciality_id;
    }
    public void setSpeciality_id(String speciality_id){
        this.speciality_id = speciality_id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProf1() {
        return prof1;
    }

    public void setProf1(String prof1) {
        this.prof1 = prof1;
    }

    public String getProf2() {
        return prof2;
    }

    public void setProf2(String prof2) {
        this.prof2 = prof2;
    }
    public Basic_r(String speciality_id, String name, String prof1, String prof2){
    this.name=name;
    this.speciality_id = speciality_id;
    this.prof1=prof1;
    this.prof2=prof2;
    }
}
