package com.scaler.lld.design.creational.abstractfactory.theme.interfaces;

import com.scaler.lld.design.creational.factory.button.models.Button;
import com.scaler.lld.design.creational.factory.button.models.CheckBox;

public interface ThemeFactory {
    Button createButton();
    CheckBox createCheckBox();
}
