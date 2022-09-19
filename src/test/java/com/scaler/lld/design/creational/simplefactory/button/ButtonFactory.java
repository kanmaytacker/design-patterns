package com.scaler.lld.design.creational.simplefactory.button;

import com.scaler.lld.design.creational.factory.button.models.Button;
import com.scaler.lld.design.creational.factory.button.models.ButtonType;
import com.scaler.lld.design.creational.factory.button.models.PrimaryButton;
import com.scaler.lld.design.creational.factory.button.models.RoundButton;

public class ButtonFactory {
    
    public static Button createButton(ButtonType type) {
        switch(type) {
            case PRIMARY:
                return new PrimaryButton();
            case ROUND:
                return new RoundButton();
        }

        throw new IllegalArgumentException("Invalid button type");
    }
}
