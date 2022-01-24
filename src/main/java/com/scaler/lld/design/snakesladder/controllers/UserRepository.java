package com.scaler.lld.design.snakesladder.controllers;

import java.util.ArrayList;
import java.util.List;

import com.scaler.lld.design.snakesladder.models.User;

public class UserRepository {

    private List<User> users = new ArrayList<>();

    public User save(User user) {
        users.add(user);
        return user;
    }
    

}
