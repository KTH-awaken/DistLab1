package com.example.distlab1.BO.Entities;

public class Order {

    private Integer id;
    private Integer userId;
    private boolean fulfilled;

    public Order() {
    }

    public Order(Integer id, Integer userId, boolean fulfilled) {
        this.id = id;
        this.userId = userId;
        this.fulfilled = fulfilled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", fulfilled=" + fulfilled +
                '}';
    }
}
