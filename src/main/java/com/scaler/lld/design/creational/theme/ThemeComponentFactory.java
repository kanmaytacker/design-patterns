package com.scaler.lld.design.creational.theme;

public interface ThemeComponentFactory {

    Button createButton();
    Menu createMenu();
    Dropdown createDropdown();
}
