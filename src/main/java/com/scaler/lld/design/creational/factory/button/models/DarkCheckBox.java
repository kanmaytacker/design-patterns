package com.scaler.lld.design.creational.factory.button.models;

public class DarkCheckBox extends CheckBox {

    @Override
    public void render() {
        System.out.println("Rendering Solid Checkbox");
    }

    @Override
    public void onSelect() {
        System.out.println("Solid Checkbox is selected");
    }
}