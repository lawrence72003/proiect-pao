package com.example.production;

import java.util.List;

public class Movie extends Production {
    private int duration;

    public Movie(String title, String description, int releaseYear, float rating, List<Actor> actors, List<Rating> ratings, int duration) {
        super(title, description, releaseYear, rating, actors, ratings);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
