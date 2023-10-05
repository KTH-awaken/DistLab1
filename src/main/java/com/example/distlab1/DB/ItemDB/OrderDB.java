package com.example.distlab1.DB.ItemDB;

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
                    throw new SQLException("Failed to create the order. Try again");
                }
            }

        }catch (SQLException e){
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
}
