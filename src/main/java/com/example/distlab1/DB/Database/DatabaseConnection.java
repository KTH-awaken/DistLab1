package com.example.distlab1.DB.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection  {
    private static DatabaseConnection instance = null;
    private final List<Connection> connectionPool = new ArrayList<>();
    private final String user;
    private final String password;


    /**
     * Thread safe method
     * @return singleton instance
     * OHA only one homie att a time protocol
     */
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }


    /**
     *
     * @return a connection from database connection pool
     * @throws DatabaseException
     */
    public synchronized Connection getConnection() throws DatabaseException {
        if (connectionPool.isEmpty()) {
            throw new DatabaseException("No connections available in the pool.");
        }

        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        try {
            if (connection.isClosed() || !connection.isValid(1000)) {
                // Replace invalid or closed connections
                connection = createNewConnection();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error checking connection validity.", e);
        }

        return connection;
    }



    /**
     * Thread safe method
     * @param connection the connection to be released
     */
    public synchronized void releaseConnection(Connection connection) {
        if (connection != null) {
            connectionPool.add(connection);
        }


    }


    /**
     * Close all connection of database connection pool
     * @throws DatabaseException
     */
    public void closeAllConnections() throws DatabaseException{
        for (Connection connection : connectionPool) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DatabaseException(e.getMessage());
            }
        }
    }



    private DatabaseConnection() {
        // TODO: add database security if possible
        this.user = "root";
        this.password = "root";
        initializeConnectionPool();
    }
    private void initializeConnectionPool() {
        int maxPoolSize = 10;
        while (connectionPool.size() < maxPoolSize) {
            connectionPool.add(createNewConnection());
        }
    }
    private Connection createNewConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/webshop";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new database connection.", e);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        if(conn == null){
            throw new RuntimeException("Connection is null.");
        }
        return conn;
    }
}

