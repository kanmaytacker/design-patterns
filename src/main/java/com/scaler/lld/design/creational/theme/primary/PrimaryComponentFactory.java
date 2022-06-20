package com.scaler.lld.design.creational.theme.primary;

import com.scaler.lld.design.creational.theme.Button;
import com.scaler.lld.design.creational.theme.Dropdown;
import com.scaler.lld.design.creational.theme.Menu;
import com.scaler.lld.design.creational.theme.ThemeComponentFactory;

public class PrimaryComponentFactory implements ThemeComponentFactory {
    @Override
    public Button createButton() {
        return new PrimaryButton();
    }

    @Override
    public Menu createMenu() {
        return new PrimaryMenu();
    }

    @Override
    public Dropdown createDropdown() {
        return new PrimaryDropdown();
    }
}
