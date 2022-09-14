package com.scaler.lld.design.creational.simplefactory.database;

public interface DatabaseDriver {

    public void connect();

    public void query();

    public void close();

}
