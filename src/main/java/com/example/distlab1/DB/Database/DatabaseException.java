package com.example.distlab1.DB.Database;

public class DatabaseException extends Exception {

    public DatabaseException(String msg, Exception cause) {
        super(msg, cause);
    }

    public DatabaseException(String msg) {
        super(msg);
    }

    public DatabaseException() {
        super();
    }
}