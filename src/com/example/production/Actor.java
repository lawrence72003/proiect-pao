package com.example.production;

import java.util.SortedSet;
import java.util.TreeSet;

public class Actor {
    private String name;
    private String biography;
    private SortedSet<Production> performances;

    public Actor(String name, String biography, SortedSet<Production> performances) {
        this.name = name;
        this.biography = biography;
        this.performances = performances;
    }

    public Actor(String name, String biography) {
        this(name, biography, new TreeSet<Production>());
    }

    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }

    public SortedSet<Production> getPerformances() {
        return performances;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setPerformances(SortedSet<Production> performances) {
        this.performances = performances;
    }
}
