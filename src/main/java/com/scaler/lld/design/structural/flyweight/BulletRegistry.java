package com.scaler.lld.design.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class BulletRegistry {
    private Map<BulletType, Bullet> bulletMap = new HashMap<>();

    public void addBullet(BulletType bulletType, Bullet bullet) {
        bulletMap.put(bulletType, bullet);
    }

    public Bullet getBullet(BulletType bulletType) {
        return bulletMap.get(bulletType);
    }
}
