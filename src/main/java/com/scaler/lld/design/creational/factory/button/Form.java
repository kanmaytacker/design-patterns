package com.scaler.lld.design.creational.factory.button;

import com.scaler.lld.design.creational.factory.button.models.Button;
import com.scaler.lld.design.creational.factory.button.models.CheckBox;

public abstract class Form {

    public abstract Button createButton();
    public abstract CheckBox createCheckBox();
    
}
