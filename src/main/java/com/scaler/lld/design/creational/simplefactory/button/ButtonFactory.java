package com.scaler.lld.design.creational.simplefactory.button;

public class ButtonFactory {

    // Step 3 - Create a static factory method
    public static Button createButton(ScreenSize screenSize, Double border, Double radius, Double length) {
        switch (screenSize) {
            case PHONE:
            case TABLET: return new RoundButton(border, radius);
            case DESKTOP: return new SquareButton(border, length);
        }

        throw new IllegalArgumentException("Invalid type: " + screenSize);

    }
}
