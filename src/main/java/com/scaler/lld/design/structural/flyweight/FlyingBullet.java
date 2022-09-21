package com.scaler.lld.design.structural.flyweight;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FlyingBullet {
    private Double x;
    private Double y;
    private Double z;
    private Double speed;
    private Bullet bullet;
}
