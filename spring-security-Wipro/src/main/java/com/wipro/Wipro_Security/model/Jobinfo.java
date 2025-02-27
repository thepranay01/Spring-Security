package com.wipro.Wipro_Security.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Jobinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

    @ElementCollection
    private Set<Integer> appliedUsers = new HashSet<>(); // using to store unique User IDs

    // Getters & Setters
    public Set<Integer> getAppliedUsers() {

        return appliedUsers;
    }

    public void setAppliedUsers(Set<Integer> appliedUsers) {

        this.appliedUsers = appliedUsers;
    }

    public Jobinfo() {
    }

    public Jobinfo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }
}
