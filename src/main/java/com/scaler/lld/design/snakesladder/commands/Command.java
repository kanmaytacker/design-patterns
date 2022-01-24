package com.scaler.lld.design.snakesladder.commands;

// Step 1 - Create common interface
public interface Command {
    
    void execute(String command);

    boolean matches(String command);
    
}
