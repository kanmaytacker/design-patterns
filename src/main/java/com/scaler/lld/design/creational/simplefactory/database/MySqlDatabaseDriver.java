package com.scaler.lld.design.creational.simplefactory.database;

public class MySqlDatabaseDriver implements DatabaseDriver {

    @Override
    public void connect() {
        System.out.println("Connecting to MySql Database");
    }

    @Override
    public void query() {
        System.out.println("Querying MySql Database");
    }

    @Override
    public void close() {
        System.out.println("Closing MySql Database");
    }
    
}
