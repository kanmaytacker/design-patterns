package com.scaler.lld.design.creational.factory.database;

public class MySqlDriver extends NewDatabaseDriver {
    
    @Override
    public void connect() {
        System.out.println("Connecting to MySql Database");
    }


    @Override
    public NewDatabaseDriver createDriver() {
        return new MySqlDriver();
    }

}
