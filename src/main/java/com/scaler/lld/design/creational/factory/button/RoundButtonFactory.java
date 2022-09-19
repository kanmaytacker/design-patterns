package com.scaler.lld.design.creational.factory.button;

import com.scaler.lld.design.creational.factory.button.models.Button;
import com.scaler.lld.design.creational.factory.button.models.RoundButton;

public class RoundButtonFactory extends ButtonFactory {

    @Override
    public Button createButton() {
        return new RoundButton();
    }
    
}
