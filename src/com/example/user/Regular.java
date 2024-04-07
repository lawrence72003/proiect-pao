package com.example.user;

import com.example.production.Production;

import java.util.SortedSet;

public class Regular extends User {
    public Regular(String username, String experience, UserType type, SortedSet<Production> favorites) {
        super(username, experience, type, favorites);
    }
}
