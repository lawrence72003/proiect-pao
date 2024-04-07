package com.example;

import com.example.production.Actor;
import com.example.production.Production;
import com.example.user.User;

import java.util.ArrayList;
import java.util.List;

public class IMDB {
    private List<Production> productions;
    private List<Actor> actors;
    private List<User> users;

    private static IMDB instance = null;

    private IMDB() {
        productions = new ArrayList<>();
        actors = new ArrayList<>();
        users = new ArrayList<>();
    }

    public static IMDB getInstance() {
        if (instance == null)
            instance = new IMDB();
        return instance;
    }

    public List<Production> getProductions() {
        return productions;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setProductions(List<Production> productions) {
        this.productions = productions;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
