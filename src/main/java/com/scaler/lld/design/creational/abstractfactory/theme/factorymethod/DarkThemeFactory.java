package com.scaler.lld.design.creational.abstractfactory.theme.factorymethod;

import com.scaler.lld.design.creational.abstractfactory.theme.interfaces.ThemeFactory;
import com.scaler.lld.design.creational.factory.button.models.Button;
import com.scaler.lld.design.creational.factory.button.models.CheckBox;
import com.scaler.lld.design.creational.factory.button.models.DarkCheckBox;
import com.scaler.lld.design.creational.factory.button.models.RoundButton;

public class DarkThemeFactory implements ThemeFactory {

    @Override
    public Button createButton() {
        return new RoundButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new DarkCheckBox();
    }

}
