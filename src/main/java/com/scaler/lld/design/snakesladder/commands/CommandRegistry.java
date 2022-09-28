package com.scaler.lld.design.snakesladder.commands;

import java.util.HashSet;
import java.util.Set;

import com.scaler.lld.design.snakesladder.exceptions.InvalidCommandException;

public class CommandRegistry {

    Set<Command> commands = new HashSet<>();

    public void register(Command command) {
        commands.add(command);
    }

    public void deregister(Command command) {
        commands.remove(command);
    }

    public void execute(String incomingCommand) {
        for (Command command : commands) {
            if (command.matches(incomingCommand)) {
                command.execute(incomingCommand);
                return;
            }
        }

        throw new InvalidCommandException();
    }
}
