package com.scaler.lld.design.creational.prototype.game;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ForegroundObject implements GraphicalObject {

    @Override
    public ForegroundObject clone() {
        return new ForegroundObject();
    }
    
}
