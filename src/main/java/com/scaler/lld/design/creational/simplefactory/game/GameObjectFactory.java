package com.scaler.lld.design.creational.simplefactory.game;

import com.scaler.lld.design.creational.prototype.game.BackgroundObject;
import com.scaler.lld.design.creational.prototype.game.ForegroundObject;
import com.scaler.lld.design.creational.prototype.game.GameObjectType;
import com.scaler.lld.design.creational.prototype.game.GraphicalObject;

// Step 1 - Create a factory class
public class GameObjectFactory {

    // Step 2 - Create a static method to create the object
    public static GraphicalObject createGameObject(GameObjectType type) {
        // Step 3 - Create the object based on the type
        switch (type) {
            case BACKGROUND:
                return new BackgroundObject();

            case FOREGROUND:
                return new ForegroundObject();

        }

        throw new IllegalArgumentException("Invalid type");
    }
}
