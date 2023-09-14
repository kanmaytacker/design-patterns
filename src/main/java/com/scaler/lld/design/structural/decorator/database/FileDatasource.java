package com.scaler.lld.design.structural.decorator.database;

// Step 2 - Concrete product class
public class FileDatasource implements Datasource {
    @Override
    public String read() {
        return "Base";
    }

    @Override
    public void write(String value) {
        System.out.println(value);
    }
}
