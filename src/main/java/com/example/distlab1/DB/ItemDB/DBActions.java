package com.example.distlab1.DB.ItemDB;

public class DBActions {

    private UserDB userDb;
    private ProductDB productDB;
    private OrderDB orderDB;


    protected DBActions() {
        this.userDb = new UserDB();
        this.productDB = new ProductDB();
        this.orderDB = new OrderDB();

    }


    public UserDB user() {
        return userDb;
    }

    public ProductDB product() {
        return productDB;
    }

    public OrderDB order() {
        return orderDB;
    }

}
