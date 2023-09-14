package com.scaler.lld.design.creational.abstractfactory.button;

// Step 3 - Factory interface
public interface ThemeFactory {

    Button createButton(Double border, Double length, Double radius);

    Radio createRadio();
}

// 5:19 - 5:25
//    ---  9:55 PM
