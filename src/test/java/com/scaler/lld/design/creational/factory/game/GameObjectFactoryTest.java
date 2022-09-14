package com.scaler.lld.design.creational.factory.game;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.scaler.lld.design.creational.prototype.game.BackgroundObject;
import com.scaler.lld.design.creational.prototype.game.ForegroundObject;
import com.scaler.lld.design.creational.prototype.game.GraphicalObject;

public class GameObjectFactoryTest {

    private static GameObjectFactory backgroundFactory = new BackgroundGameObjectFactory();
    private static GameObjectFactory foregroundFactory = new ForegroundGameObjectFactory();

    @Test
    public void testForegroundFactory() {
        GraphicalObject foregroundObject = foregroundFactory.createGameObject();
        assertNotNull("If the simple factory method is called, the object should not be null", foregroundObject);
        assertTrue("If the type is FOREGROUND, the object should be of type ForegroundObject",
                foregroundObject instanceof ForegroundObject);
    }

    @Test
    public void testBackgroundFactory() {
        GraphicalObject backgroundObject = backgroundFactory.createGameObject();
        assertNotNull("If the simple factory method is called, the object should not be null", backgroundObject);
        assertTrue("If the type is BACKGROUND, the object should be of type BackgroundObject",
                backgroundObject instanceof BackgroundObject);
    }

}
