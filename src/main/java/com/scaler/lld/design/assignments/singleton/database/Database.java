package com.scaler.lld.design.assignments.singleton.database;

public class Database {

    private static Database database = null;
    private Database()
    {

    }

    public static Database getInstance()
    {
        if(database ==null)
        {
            synchronized (Database.class)
            {
                if(database == null)
                {
                    database = new Database();
                }
            }
        }
        return database;
    }
}