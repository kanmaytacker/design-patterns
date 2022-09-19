package com.scaler.lld.design.creational.prototype.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class GameObjectTest {

    @Test
    public void testCloneObject() {
        // Step 4 - Create a prototype object
        BackgroundObject prototype = new BackgroundObject(100, 200, 100, 200, BackgroundObjectType.TREE);
        BackgroundObject clone = prototype.clone();

        assertNotNull("If clone method is called, it should return a new object", clone);
        assertEquals("If clone method is called, it should return same value for x", prototype.getX(), clone.getX());

        clone.setX(200);
        clone.setY(300);
    }

    @Test
    public void testCloneObjectWithRegistry() {

        // Initialise registry
        BackgroundObjectRegistry registry = new BackgroundObjectRegistry();

        // Step 4 - Create a prototype object
        BackgroundObject prototype = new BackgroundObject(100, 200, 100, 200, BackgroundObjectType.TREE);
        registry.registerObject(prototype);

        BackgroundObject clone = registry.getObject(BackgroundObjectType.TREE).clone();

        assertNotNull("If clone method is called, it should return a new object", clone);
        assertEquals("If clone method is called, it should return same value for x", prototype.getX(), clone.getX());

        clone.setX(200);
        clone.setY(300);
    }
}
