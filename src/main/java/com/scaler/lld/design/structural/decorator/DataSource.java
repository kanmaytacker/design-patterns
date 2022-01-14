package com.scaler.lld.design.structural.decorator;

public interface DataSource {

    public String read();

    public void write(String value);
}
