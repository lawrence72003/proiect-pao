package com.example.user;

import com.example.production.Production;

import java.util.SortedSet;

public class Regular extends User {
    public Regular(String username, int experience, UserType type, SortedSet<Production> favorites, Credentials credentials) {
        super(username, experience, type, favorites, credentials);
    }
}
