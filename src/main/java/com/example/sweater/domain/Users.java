package com.example.sweater.domain;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private Integer salary;


    public Users() {
    }

    public Users(int salary, String name) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;

    }

    public void setSalary(int salary) {
        this.salary = salary;

    }

    public void setName(String name) {
        this.name = name;
    }
}