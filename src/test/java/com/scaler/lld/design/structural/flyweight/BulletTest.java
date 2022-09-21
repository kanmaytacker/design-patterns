package com.scaler.lld.design.structural.flyweight;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BulletTest {

    @Test
    public void testFlyweight() {
        Bullet bullet = new Bullet(10.0, new byte[100]);
        FlyingBullet flyingBullet = FlyingBullet.builder()
                .x(10.0)
                .y(20.0)
                .z(30.0)
                .speed(100.0)
                .bullet(bullet)
                .build();

        FlyingBullet flyingBullet2 = FlyingBullet.builder()
                .x(10.0)
                .y(20.0)
                .z(30.0)
                .speed(100.0)
                .bullet(bullet)
                .build();

        assertEquals("If new bullets are created, they should use the same bullet object", flyingBullet.getBullet(),
                flyingBullet2.getBullet());
    }
}
