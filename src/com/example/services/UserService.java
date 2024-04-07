package com.example.services;

import com.example.IMDB;
import com.example.user.User;

import java.util.List;

public class UserService {
    public List<User> getAllUsers() {
        return IMDB.getInstance().getUsers();
    }

    public void addUser(User user) {
        IMDB.getInstance().getUsers().add(user);
    }

    public void removeUser(User user) {
        IMDB.getInstance().getUsers().remove(user);
    }
}
