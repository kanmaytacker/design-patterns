package com.scaler.lld.design.creational.simplefactory.database;

public class OracleDatabaseDriver implements DatabaseDriver {

    @Override
    public void connect() {
        System.out.println("Connecting to Oracle Database");
    }

    @Override
    public void query() {
        System.out.println("Querying Oracle Database");
    }

    @Override
    public void close() {
        System.out.println("Closing Oracle Database");
    }

}
