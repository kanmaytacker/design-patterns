package com.scaler.lld.design.creational.factory.button;

import com.scaler.lld.design.creational.factory.button.models.Button;
import com.scaler.lld.design.creational.factory.button.models.CheckBox;
import com.scaler.lld.design.creational.factory.button.models.RoundButton;

public class MobileForm extends Form {

    @Override
    public Button createButton() {
        return new RoundButton();
    }

    @Override
    public CheckBox createCheckBox() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
