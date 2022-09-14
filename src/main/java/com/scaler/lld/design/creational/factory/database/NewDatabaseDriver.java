package com.scaler.lld.design.creational.factory.database;


public abstract class NewDatabaseDriver {

    public NewDatabaseDriver initialise() {
        NewDatabaseDriver driver = createDriver();
        driver.connect();
        return driver;
    }

    public abstract void connect();

    public abstract NewDatabaseDriver createDriver();
    
}
