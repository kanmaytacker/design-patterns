package com.scaler.lld.design.snakesladder.controllers;

import com.scaler.lld.design.snakesladder.models.User;

public class UserService {

    UserRepository repository = new UserRepository();

    public User createUser(String name, String email) {
        
        // Created user object
        User user = new User();
        user.setEmail(email);
        user.setUsername(name);

        // Persisted user object
        return repository.save(user);
    }
}
