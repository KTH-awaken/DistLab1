package com.example.distlab1.DB.ItemDB;

import com.example.distlab1.BO.Entities.Order;
import com.example.distlab1.DB.DBManager;
import com.example.distlab1.DB.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDB {


    protected OrderDB(){}



    public void insertOrder(int userid, ArrayList<Integer> productIds) throws DatabaseException {
        DBManager db = DBManager.getInstance();
        Connection conn = db.getConnection();

        try{
            // Start Transaction
            db.startTransaction(conn);

            String orderSql = "insert into t_orders (user_id) values (?)";
            PreparedStatement preparedStatement = conn.prepareStatement(orderSql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,userid);
            int orderResult = preparedStatement.executeUpdate();

            if (orderResult <= 0) {
                db.rollbackTransaction(conn);
                throw new DatabaseException("Failed to create the order. Try again");

            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int orderId = generatedKeys.getInt(1);
                    // Insert each product to t_order_product
                    insertProductsIntoOrder(conn, orderId, productIds);
                    // Commit transaction
                    db.commitTransaction(conn);

                } else {
                    db.rollbackTransaction(conn);
                    throw new SQLException("Failed to create the order. Try again");
                }
            }

        }catch (SQLException e){
            db.rollbackTransaction(conn);
            throw new DatabaseException(e.getMessage(), e);
        }

    }


    private static void insertProductsIntoOrder(Connection conn, int orderId, ArrayList<Integer> productIds) throws  SQLException {
        String insertProductSql = "INSERT INTO t_order_product (order_id, product_id) VALUES (?, ?)";
        PreparedStatement productStatement = conn.prepareStatement(insertProductSql);

        for (int productId : productIds) {
            productStatement.setInt(1, orderId);
            productStatement.setInt(2, productId);
            productStatement.addBatch();
        }

        int[] productResult = productStatement.executeBatch();

        for (int result : productResult) {
            if (result <= 0) {
                throw new SQLException("Failed to insert a product into the order");
            }
        }
    }
    public static ArrayList<Order> getOrders(){
        ArrayList<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM t_orders";
        try {
            Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("user_id"));
                order.setFulfilled(resultSet.getBoolean("fullfilled"));

                orders.add(order);
            }
            DBManager.getInstance().releaseConnection(conn);//todo kolla om det är smart
        } catch (DatabaseException e) {
            throw new RuntimeException(e+"Knas i get orders ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
    public static void packOrder(Connection con){
//todo remove
    }
}
