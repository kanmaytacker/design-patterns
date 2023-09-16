package com.scaler.lld.design.creational.parleg;
public abstract class Button {
    private Double border;
    public Button(Double border) {
        this.border = border;
    }

    abstract public  void onClick() ;

    abstract public void render();
}
