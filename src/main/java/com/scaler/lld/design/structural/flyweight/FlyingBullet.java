package com.scaler.lld.design.structural.flyweight;

import lombok.AllArgsConstructor;

// Step 2 - Extrinsic state
@AllArgsConstructor
public class FlyingBullet {
    private Double x, y, z;
    private Double direction;

    // Step 3 - Add a has-a relation
    private Bullet bullet;

}
