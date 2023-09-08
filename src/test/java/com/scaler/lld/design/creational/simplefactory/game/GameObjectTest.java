package com.scaler.lld.design.creational.simplefactory.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import com.scaler.lld.design.creational.prototype.game.BackgroundObject;
import com.scaler.lld.design.creational.prototype.game.ForegroundObject;
import com.scaler.lld.design.creational.prototype.game.GameObjectType;
import com.scaler.lld.design.creational.prototype.game.GraphicalObject;

public class GameObjectTest {
    
    @Test
    public void testSimpleFactory() {
        GraphicalObject foregroundObject = GameObjectFactory.createGameObject(GameObjectType.FOREGROUND);
        assertNotNull(foregroundObject);
        assertTrue(foregroundObject instanceof ForegroundObject);

        GraphicalObject backgroundObject = GameObjectFactory.createGameObject(GameObjectType.BACKGROUND);
        assertNotNull(backgroundObject);
        assertTrue(backgroundObject instanceof BackgroundObject);
    }
}
