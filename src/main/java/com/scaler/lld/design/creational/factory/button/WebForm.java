package com.scaler.lld.design.creational.factory.button;

import com.scaler.lld.design.creational.factory.button.models.Button;
import com.scaler.lld.design.creational.factory.button.models.PrimaryButton;

public class WebForm extends Form {

    @Override
    public Button createButton() {
        return new PrimaryButton();
    }
    
}
