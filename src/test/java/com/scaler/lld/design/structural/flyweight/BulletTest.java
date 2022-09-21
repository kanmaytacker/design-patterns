package com.scaler.lld.design.structural.flyweight;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class BulletTest {
    private BulletRegistry bulletRegistry;

    @Before
    public void setUp() {
        bulletRegistry = new BulletRegistry();
        bulletRegistry.addBullet(BulletType.BULLET_9MM, new Bullet(0.5, new byte[10], BulletType.BULLET_9MM));
        bulletRegistry.addBullet(BulletType.BULLET_45MM, new Bullet(1.0, new byte[20], BulletType.BULLET_45MM));
        bulletRegistry.addBullet(BulletType.BULLET_50MM, new Bullet(1.5, new byte[30], BulletType.BULLET_50MM));
    }

    @Test
    public void testFlyweight() {
        Bullet bullet = new Bullet(10.0, new byte[100], BulletType.BULLET_9MM);
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

    @Test
    public void testFlyweightRegistry() {
        Bullet bullet = bulletRegistry.getBullet(BulletType.BULLET_9MM);
        assertNotNull("If bullet is added to registry, it should be returned", bullet);

        FlyingBullet flyingBullet = FlyingBullet.builder()
                .x(10.0)
                .y(20.0)
                .z(30.0)
                .speed(100.0)
                .bullet(bullet)
                .build();

        assertEquals("If new bullets are created, they should use the same bullet object", bullet,
                flyingBullet.getBullet());
    }
}
