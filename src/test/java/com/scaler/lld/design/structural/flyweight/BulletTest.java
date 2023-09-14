package com.scaler.lld.design.structural.flyweight;

import org.junit.jupiter.api.Test;

public class BulletTest {

    @Test
    void createFlyweight() {

        BulletRegistry registry = new BulletRegistry();

        Bullet bullet = new Bullet("IMAGE", 0.9, 10.0, BulletType.NINE_MM);
        Bullet bullet2 = new Bullet("IMAGE_2", 1.1, 20.0, BulletType.ELEVEN_MM);

        registry.addBullet(bullet);
        registry.addBullet(bullet2);


        FlyingBullet flyingBullet1 = new FlyingBullet(0.0, 0.0, 0.0, -12.0, registry.getBullet(BulletType.NINE_MM));
        FlyingBullet flyingBullet2 = new FlyingBullet(10.0, 10.0, 10.0, -12.0, registry.getBullet(BulletType.ELEVEN_MM));

    }
}
