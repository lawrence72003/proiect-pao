package com.example.services;

import com.example.IMDB;
import com.example.production.Production;
import com.example.user.User;

import java.util.List;

public class UserService {
    public static List<User> getAllUsers() {
        return IMDB.getInstance().getUsers();
    }

    public static List<User> getUserByUsername(String username) {
        return IMDB.getInstance().getUsers().stream().filter(user -> user.getUsername().equals(username)).toList();
    }

    public static void addUser(User user) {
        IMDB.getInstance().getUsers().add(user);
    }

    public static void removeUser(User user) {
        IMDB.getInstance().getUsers().remove(user);
    }

    public static void addFavorite(User user, Production production) {
        user.getFavorites().add(production);
    }

    public static void removeFavorite(User user, Production production) {
        user.getFavorites().remove(production);
    }
}
