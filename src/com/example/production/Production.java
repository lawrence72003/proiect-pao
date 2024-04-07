package com.example.production;

import java.util.List;

public abstract class Production implements Comparable<Production> {
    protected String title;
    protected String description;
    protected int releaseYear;
    protected float rating;
    protected List<Actor> actors;
    protected List<Rating> ratings;

    public Production(String title, String description, int releaseYear, float rating, List<Actor> actors, List<Rating> ratings) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.actors = actors;
        this.ratings = ratings;
    }

    @Override
    public int compareTo(Production production) {
        return this.title.compareTo(production.title);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public float getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
