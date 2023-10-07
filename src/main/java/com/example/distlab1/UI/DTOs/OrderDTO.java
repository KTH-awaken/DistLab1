package com.example.distlab1.UI.DTOs;

public class OrderDTO {
    private Integer id;
    private Integer userId;
    private boolean fulfilled;

    public OrderDTO(){

    }

    public OrderDTO(Integer id, Integer userId, boolean fullfilled) {
        this.id = id;
        this.userId = userId;
        this.fulfilled = fullfilled;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Integer getUserId() {return userId;}

    public void setUserId(Integer userId) {this.userId = userId;}

    public boolean isFulfilled() {return fulfilled;}

    public void setFulfilled(boolean fulfilled) {this.fulfilled = fulfilled;}


    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", fullfilled=" + fulfilled +
                '}';
    }
}
//    create table t_products ( todo remvoe
//        id int primary key auto_increment,
//        name varchar(255) not null,
//        description varchar(255) not null,
//        quantity int not null,
//        price int not null,
//        image longblob not null
//        );
//
//
//
//        create table t_orders (
//        id int primary key auto_increment,
//        user_id int,
//        fullfilled boolean default false,
//        created_date datetime not null default (current_date()),
//        foreign key (user_id) references t_users(id)
//        );