package com.scaler.lld.design.snakesladder.commands;

import java.util.Arrays;
import java.util.List;

import com.scaler.lld.design.snakesladder.controllers.UserController;

public class CreateUser implements Command{

    private static final String COMMAND_NAME = "create_user";
    private UserController controller = new UserController();

    @Override
    public void execute(String command) {
        List<String> tokens = Arrays.asList(command.split(" "));
        String username = tokens.get(1);
        String email = tokens.get(2);
        controller.createUser(username, email);
    }

    @Override
    public boolean matches(String command) {
       List<String> tokens = Arrays.asList(command.split(" "));
       if (tokens.size() > 0 && tokens.get(0).equals(COMMAND_NAME)) {
           return true;
       }
        return false;
    }
    
}
// sl match_command 12 1212 