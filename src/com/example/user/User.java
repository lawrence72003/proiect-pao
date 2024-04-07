package com.example.user;

import com.example.production.Production;

import java.util.SortedSet;

public abstract class User {
    protected String username;
    protected String experience;
    protected UserType type;
    protected SortedSet<Production> favorites;
    protected Credentials credentials;

    public User(String username, String experience, UserType type, SortedSet<Production> favorites, Credentials credentials) {
        this.username = username;
        this.experience = experience;
        this.type = type;
        this.favorites = favorites;
        this.credentials = credentials;
    }

    public String getUsername() {
        return username;
    }

    public String getExperience() {
        return experience;
    }

    public UserType getType() {
        return type;
    }

    public SortedSet<Production> getFavorites() {
        return favorites;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public void setFavorites(SortedSet<Production> favorites) {
        this.favorites = favorites;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
