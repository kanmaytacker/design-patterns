package com.scaler.lld.design.structural.decorator;

public class FileDataSource implements DataSource {

    @Override
    public String read() {
        return "Base";
    }

    @Override
    public void write(String value) {
        System.out.println(value);        
    }

}
