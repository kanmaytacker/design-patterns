package com.scaler.lld.design.creational.simplefactory.button;

import lombok.Getter;

// Step 2 - Create the concrete product classes
@Getter

public class RoundButton extends Button {
    private Double radius;

    public RoundButton(Double border, Double radius) {
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
