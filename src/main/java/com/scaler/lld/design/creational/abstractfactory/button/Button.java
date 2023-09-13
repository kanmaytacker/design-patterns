package com.scaler.lld.design.creational.abstractfactory.button;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Step 1 - Create a common product interface
@AllArgsConstructor
@Getter
public abstract class Button {

    private Double border;

    public abstract void render();

    public abstract void onClick();
}
