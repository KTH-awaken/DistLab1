package com.example.distlab1.DB.ItemDB;

public class DBActions {

    private UserDB userDb;
    private ProductDB productDB;

    protected DBActions() {
        this.userDb = new UserDB();
        this.productDB = new ProductDB();

    }


    public UserDB user() {
        return userDb;
    }

    public ProductDB product() {
        return productDB;
    }
}
