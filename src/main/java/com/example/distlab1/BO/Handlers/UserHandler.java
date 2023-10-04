package com.example.distlab1.BO.Handlers;


import com.example.distlab1.BO.Entities.User;
import com.example.distlab1.DB.DatabaseException;
import com.example.distlab1.UI.ItemInfo.UserInfo;

import java.util.ArrayList;

public class UserHandler {


     static public ArrayList<UserInfo> getUsers() throws DatabaseException {
        DBContext db = new DBContext();
        ArrayList<User> users =  db.user().getUsers();
        ArrayList<UserInfo> usersToReturn = new ArrayList<>();
        for (User user : users) {
            int id = user.getId();
            String username = user.getUsername();
            String email = user.getEmail();
            String role = user.getRole();
            usersToReturn.add(new UserInfo(id, username, email, role));
        }
        return usersToReturn;
    }

    static public UserInfo handleLogin(String email, String password) throws DatabaseException{
        DBContext db = new DBContext();
        User user = db.user().getUserByEmailAndPassword(email,password);
        if(user != null){
            return mapUser(user);
        }
        return null;
    }

    static public boolean registerUser(String username, String email, String password) throws DatabaseException{
        DBContext db = new DBContext();
        return db.user().addUser(username, email,password);
    }


    private static UserInfo mapUser(User u){
         return new UserInfo(u.getId(),u.getUsername(),u.getEmail(),u.getRole());
    }

}
