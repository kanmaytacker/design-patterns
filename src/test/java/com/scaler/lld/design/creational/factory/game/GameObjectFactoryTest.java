package com.scaler.lld.design.creational.factory.game;

import com.scaler.lld.design.creational.prototype.game.BackgroundObject;
import com.scaler.lld.design.creational.prototype.game.ForegroundObject;
import com.scaler.lld.design.creational.prototype.game.GraphicalObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameObjectFactoryTest {

    private static GameObjectFactory backgroundFactory = new BackgroundGameObjectFactory();
    private static GameObjectFactory foregroundFactory = new ForegroundGameObjectFactory();

    @Test
    public void testForegroundFactory() {
        GraphicalObject foregroundObject = foregroundFactory.createGameObject();
        assertNotNull(foregroundObject, "If the simple factory method is called, the object should not be null");
        assertTrue(foregroundObject instanceof ForegroundObject, "If the type is FOREGROUND, the object should be of type ForegroundObject");
    }

    @Test
    public void testBackgroundFactory() {
        GraphicalObject backgroundObject = backgroundFactory.createGameObject();
        assertNotNull(backgroundObject, "If the simple factory method is called, the object should not be null");
        assertTrue(backgroundObject instanceof BackgroundObject, "If the type is BACKGROUND, the object should be of type BackgroundObject");
    }

}
