package com.scaler.lld.design.snakesladder.controllers;

import com.scaler.lld.design.snakesladder.models.User;

public class UserController {
    
    private UserService service = new UserService();

    public User createUser(String username, String email) {
        return service.createUser(username, email);
    }
}
