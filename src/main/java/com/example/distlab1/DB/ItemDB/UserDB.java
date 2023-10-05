package com.example.distlab1.DB.ItemDB;

import com.example.distlab1.BO.Entities.User;
import com.example.distlab1.DB.DBManager;
import com.example.distlab1.DB.DatabaseException;

import java.sql.*;
import java.util.ArrayList;

public class UserDB {


    protected UserDB(){};

    public ArrayList<User> getUsers() throws DatabaseException {
        ArrayList<User> userList = new ArrayList<>();

        try {
            // Acquire connection
            Connection conn = DBManager.getInstance().getConnection();
            String sql = "SELECT * FROM t_users";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and populate the user list
            while (resultSet.next()) {
                userList.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                ));
            }
            // Release connection
            DBManager.getInstance().releaseConnection(conn);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(),e);
        }
        return userList;
    }

    public User getUserById(int id) throws DatabaseException {
        User user = null;
        try {
            // Acquire connection
            Connection conn = DBManager.getInstance().getConnection();
            String sql = "SELECT * FROM t_users WHERE id = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                user = new User(userId, username, email, password, role);
            }

            // Release connection
            DBManager.getInstance().releaseConnection(conn);

        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(), e);
        }

        return user;
    }

    public boolean addUser(String username, String email, String password) throws DatabaseException {
        boolean success = false;

        // Check if the user exists
        if (userExists(email)) {
            return false;
        }

        try {
            DBManager db = DBManager.getInstance();
            // Acquire connection
            Connection conn  = db.getConnection();

            // Start transaction
            db.startTransaction(conn);

            // Insert into t_users table
            String sql = "INSERT INTO t_users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement userStatement = conn.prepareStatement(sql);
            userStatement.setString(1, username);
            userStatement.setString(2, email);
            userStatement.setString(3, password);

            int result = userStatement.executeUpdate();
            if (result > 0) {
                // Commit transaction
                success = true;
                db.commitTransaction(conn);
            }

            // Release connection
            db.releaseConnection(conn);

        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(), e);
        }

        return success;
    }

    public User getUserByEmailAndPassword(String email, String password) throws DatabaseException {
        User user = null;
        try {

            // Acquire connection
            Connection conn = DBManager.getInstance().getConnection();
            String sql = "SELECT * FROM t_users WHERE email = ? AND password = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if a user with the specified email and password is found
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }

            // Release connection
            DBManager.getInstance().releaseConnection(conn);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
        return user;
    }

    public boolean updateUserById(int id, User updated) throws DatabaseException {
        boolean success = false;

        try {
            DBManager db = DBManager.getInstance();
            // Acquire connection
            Connection conn = db.getConnection();
            String sql = "UPDATE t_users SET username = ?, email = ?, password = ?, role = ? WHERE id = ?";

            db.startTransaction(conn);
            // Start transaction
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, updated.getUsername());
            preparedStatement.setString(2, updated.getEmail());
            preparedStatement.setString(3, updated.getPassword());
            preparedStatement.setString(4, updated.getRole());
            preparedStatement.setInt(5, id);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                success = true ;
                db.commitTransaction(conn);
            }


            // Release connection
            db.releaseConnection(conn);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(), e);
        }

        return success;
    }

    private boolean userExists(String email) throws DatabaseException {
        try {
            // Acquire connection
            Connection conn = DBManager.getInstance().getConnection();
            String sql = "SELECT * FROM t_users WHERE email = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Release connection
            DBManager.getInstance().releaseConnection(conn);

            // Return if a user with the specified email exist
            return resultSet.next();

        } catch (SQLException  e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }



}
