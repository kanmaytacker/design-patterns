package com.scaler.lld.design.creational.theme.dark;

import com.scaler.lld.design.creational.theme.Button;
import com.scaler.lld.design.creational.theme.Dropdown;
import com.scaler.lld.design.creational.theme.Menu;
import com.scaler.lld.design.creational.theme.ThemeComponentFactory;

public class DarkComponentFactory implements ThemeComponentFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public Menu createMenu() {
        return new DarkMenu();
    }

    @Override
    public Dropdown createDropdown() {
        return new DarkDropdown();
    }
}
