package com.example.services;

import com.example.IMDB;
import com.example.user.User;

import java.util.List;

public class UserService {
    public static List<User> getAllUsers() {
        return IMDB.getInstance().getUsers();
    }

    public static void addUser(User user) {
        IMDB.getInstance().getUsers().add(user);
    }

    public static void removeUser(User user) {
        IMDB.getInstance().getUsers().remove(user);
    }
}
