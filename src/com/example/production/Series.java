package com.example.production;

import java.util.List;
import java.util.Map;

public class Series extends Production {
    private Map<String, List<Episode>> seasons;

    public Series(String title, String description, int releaseYear, float rating, List<Actor> actors, List<Rating> ratings, Map<String, List<Episode>> seasons) {
        super(title, description, releaseYear, rating, actors, ratings);
        this.seasons = seasons;
    }

    public Map<String, List<Episode>> getSeasons() {
        return seasons;
    }

    public void setSeasons(Map<String, List<Episode>> seasons) {
        this.seasons = seasons;
    }
}
