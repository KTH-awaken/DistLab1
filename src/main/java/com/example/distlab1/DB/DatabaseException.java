package com.example.distlab1.DB;

public class DatabaseException extends Exception {
    /**
     * Initializes a new instance of the DatabaseException class with a specified error message and a reference to the inner exception that is the cause of this exception.
     * @param msg The error message that explains the reason for the exception.
     * @param cause The exception that is the cause of the current exception.
     */
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