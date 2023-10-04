package com.example.distlab1.DB.DAO;

import com.example.distlab1.BO.Entities.ActionResult;
import com.example.distlab1.BO.Entities.User;
import com.example.distlab1.DB.Database.DatabaseException;

import java.util.List;

public interface IUserDAO {

    List<User> getAllUsers() throws DatabaseException;
    User getUserById(int id) throws DatabaseException;

    /**
     * Find a matching user with given email and password
     * @param email
     * @param password
     * @return
     * @throws DatabaseException
     */
    User getUserByEmailAndPassword(String email, String password) throws DatabaseException;

    /**
     * Create user record and empty cart record
     * @param username full name
     * @param email user email
     * @param password user password
     * @return actionResult of whether the action succeed or not and the user object
     * @throws DatabaseException
     */
    ActionResult<User> addUser(String username, String email, String password) throws DatabaseException;


    boolean updateUserById(int id, User updated) throws DatabaseException;
    User deleteUserById(int id);
}
