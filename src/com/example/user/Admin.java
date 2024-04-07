package com.example.user;

import java.util.SortedSet;
import com.example.production.Production;

public class Admin extends User {
    public Admin(String username, int experience, UserType type, SortedSet<Production> favorites, Credentials credentials) {
        super(username, experience, type, favorites, credentials);
    }
}
