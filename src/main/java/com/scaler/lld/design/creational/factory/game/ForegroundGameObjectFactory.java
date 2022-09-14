package com.scaler.lld.design.creational.factory.game;

import com.scaler.lld.design.creational.prototype.game.ForegroundObject;

public class ForegroundGameObjectFactory implements GameObjectFactory {

    @Override
    public ForegroundObject createGameObject() {
        return new ForegroundObject();
    }
}
