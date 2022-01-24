package com.scaler.lld.design.snakesladder.commands;

import java.util.Arrays;
import java.util.List;

public class CreateUser implements Command{

    private static final String COMMAND_NAME = "create_user";

    @Override
    public void execute(String command) {
        System.out.println("User created!");
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