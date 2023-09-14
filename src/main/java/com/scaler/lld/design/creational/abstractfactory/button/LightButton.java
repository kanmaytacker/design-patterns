package com.scaler.lld.design.creational.abstractfactory.button;

import lombok.Getter;

@Getter
public class LightButton extends Button {
    private Double length;

    public LightButton(Double border, Double length) {
        super(border);
        this.length = length;
    }

    public void onClick() {
        System.out.println("Square Btn was clicked!");
    }

    public void render() {
        System.out.println("Rendered!");
    }

}
