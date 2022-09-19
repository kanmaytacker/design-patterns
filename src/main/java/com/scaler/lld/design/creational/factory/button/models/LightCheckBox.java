package com.scaler.lld.design.creational.factory.button.models;

public class LightCheckBox extends CheckBox {

    @Override
    public void render() {
        System.out.println("Rendering Animated Checkbox");
    }

    @Override
    public void onSelect() {
        System.out.println("Animated Checkbox is selected");
    }
}