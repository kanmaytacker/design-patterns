package com.scaler.lld.design.creational.prototype.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class GameObjectTest {

    @Test
    public void testCloneObject() {
        // Step 4 - Create a prototype object
        BackgroundObject prototype = new BackgroundObject(100, 200, 100, 200, BackgroundObjectType.TREE);
        BackgroundObject clone = prototype.clone();

        assertNotNull(clone, "If clone method is called, it should return a new object");
        assertEquals(prototype.getX(), clone.getX(), "If clone method is called, it should return same value for x");

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

        assertNotNull(clone, "If clone method is called, it should return a new object");
        assertEquals(prototype.getX(), clone.getX(), "If clone method is called, it should return same value for x");

        clone.setX(200);
        clone.setY(300);
    }
}
