package com.example.distlab1.DB.DAO.Implementation;

import com.example.distlab1.BO.Entities.ActionResult;
import com.example.distlab1.BO.Entities.User;
import com.example.distlab1.DB.DAO.IUserDAO;
import com.example.distlab1.DB.Database.DBManager;
import com.example.distlab1.DB.Database.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO  implements IUserDAO {
    @Override
    public List<User> getAllUsers() throws DatabaseException {
        List<User> userList = new ArrayList<>();

        try {
            // Acquire connection
            Connection conn = DBManager.getInstance().getConnection();
            String sql = "SELECT * FROM t_users";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and populate the user list
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(resultSet.getString("role"));
                userList.add(user);
            }

            // Release connection
            DBManager.getInstance().releaseConnection(conn);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(),e);
        }

        return userList;
    }


    @Override
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
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
            }

            // Release connection
            DBManager.getInstance().releaseConnection(conn);

        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(), e);
        }

        return user;
    }

    @Override
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



    @Override
    public ActionResult<User> addUser(String username, String email, String password) throws DatabaseException {
        ActionResult<User> actionResult = new ActionResult<>();

        // Check if the user exists
        if (userExists(email)) {
            return new ActionResult<>(false, "User with the given email already exists", null);
        }


        try {
            // Acquire connection
            Connection conn  = DBManager.getInstance().getConnection();

            // Start transaction
            conn.setAutoCommit(false);

            // Insert into t_users table
            String insertUserSQL = "INSERT INTO t_users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement userStatement = conn.prepareStatement(insertUserSQL, Statement.RETURN_GENERATED_KEYS);
            userStatement.setString(1, username);
            userStatement.setString(2, email);
            userStatement.setString(3, password);

            int result = userStatement.executeUpdate();

            if (result > 0) {
                ResultSet generatedKeys = userStatement.getGeneratedKeys();
                int userId = -1;

                if (generatedKeys.next()) {
                    userId = generatedKeys.getInt(1);

                    // Create a cart for the user
                    String cartSql = "INSERT INTO t_carts (user_id) VALUES (?)";
                    PreparedStatement cartStatement = conn.prepareStatement(cartSql);
                    cartStatement.setInt(1, userId);

                    int cartInsertResult = cartStatement.executeUpdate();

                    if (cartInsertResult > 0) {
                        actionResult.setSuccess(true);
                        actionResult.setMessage("User registered successfully");
                        // Commit transaction
                        conn.commit();
                        conn.setAutoCommit(true);

                    }
                }
            }
            // Release connection
            DBManager.getInstance().releaseConnection(conn);

        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(), e);
        }

        return actionResult;
    }




    @Override
    public boolean updateUserById(int id, User updated) throws DatabaseException {
        boolean success = false;

        try {
            // Acquire connection
            Connection conn = DBManager.getInstance().getConnection();
            String sql = "UPDATE t_users SET username = ?, email = ?, password = ?, role = ? WHERE id = ?";

            conn.setAutoCommit(false);
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
                conn.commit();
            }

            conn.setAutoCommit(true);

            // Release connection
            DBManager.getInstance().releaseConnection(conn);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(), e);
        }

        return success;
    }

    @Override
    public User deleteUserById(int id) {
        return null;
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
