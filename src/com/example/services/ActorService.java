package com.example.services;

import com.example.IMDB;
import com.example.production.Actor;

import java.util.List;

public class ActorService {
    public static List<Actor> getAllActors() {
        return IMDB.getInstance().getActors();
    }

    public static List<Actor> getActorByName(String name) {
        return IMDB.getInstance().getActors().stream().filter(actor -> actor.getName().equals(name)).toList();
    }

    public static void addActor(Actor actor) {
        getAllActors().add(actor);
    }

    public static void removeActor(Actor actor) {
        getAllActors().remove(actor);
    }
}
