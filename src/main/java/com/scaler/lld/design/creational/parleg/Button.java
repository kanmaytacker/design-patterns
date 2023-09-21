package com.scaler.lld.design.creational.parleg;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Button {

    private Double border;

    public abstract void render();

    public abstract void onClick();
}
