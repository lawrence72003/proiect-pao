package com.example.user;

import java.util.SortedSet;
import com.example.production.Production;

public class Admin extends User {
    public Admin(String username, String experience, UserType type, SortedSet<Production> favorites) {
        super(username, experience, type, favorites);
    }
}
