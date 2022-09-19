package com.scaler.lld.design.creational.abstractfactory.theme.factorymethod;

import com.scaler.lld.design.creational.abstractfactory.theme.interfaces.ThemeFactory;
import com.scaler.lld.design.creational.factory.button.models.Button;
import com.scaler.lld.design.creational.factory.button.models.CheckBox;
import com.scaler.lld.design.creational.factory.button.models.LightCheckBox;
import com.scaler.lld.design.creational.factory.button.models.PrimaryButton;

public class LightThemeFactory implements ThemeFactory {

    @Override
    public Button createButton() {
        return new PrimaryButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new LightCheckBox();
    }
}