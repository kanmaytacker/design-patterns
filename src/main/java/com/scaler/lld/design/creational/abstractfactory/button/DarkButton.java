package com.scaler.lld.design.creational.abstractfactory.button;

import lombok.Getter;

// Step 2 - Create the concrete product classes
@Getter

public class DarkButton extends Button {
    private Double radius;

    public DarkButton(Double border, Double radius) {
        super(border);
        this.radius = radius;
    }

    @Override
    public void onClick() {
        System.out.println("Round Btn was clicked!");
    }

    @Override
    public void render() {
        System.out.println("Rendered!");
    }

}
