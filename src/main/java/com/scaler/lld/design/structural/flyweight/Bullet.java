package com.scaler.lld.design.structural.flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Step 1 - Create the flyweight object i.e. intrinsic state

@Getter
@AllArgsConstructor
public class Bullet {
    private Double weight;
    private byte[] image;
    private BulletType bulletType;
}
