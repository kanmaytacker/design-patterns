package com.scaler.lld.design.creational.parleg;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SquareButton {
    private Double length;
    private Double border;

    public void onClick() {
        System.out.println("Square Btn was clicked!");
    }

    public void render() {
        System.out.println("Rendered!");
    }

}
