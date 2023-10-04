package com.example.distlab1.DB.ItemDB;

import com.example.distlab1.BO.Entities.Product;
import com.example.distlab1.DB.DBManager;
import com.example.distlab1.DB.DatabaseException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;

public class ProductDB {

    protected ProductDB(){};

    public ArrayList<Product> getProducts() throws DatabaseException {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM t_products";

        try {
            // Acquire connection
            Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setPrice(resultSet.getDouble("price"));
                product.setBase64Image(getBase64Image(resultSet.getBlob("image")));

                products.add(product);
            }

            // Release connection
            DBManager.getInstance().releaseConnection(conn);
        } catch (SQLException | IOException  e) {
            throw new DatabaseException(e.getMessage(), e);
        }
        return products;

    }

    public Product getProductById(int id) throws DatabaseException {
        Product product = new Product();
        String sql = "select * from t_products where id = " + id;

        try {
            // Acquire connection
            Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet  = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setPrice(resultSet.getDouble("price"));
                product.setBase64Image(getBase64Image(resultSet.getBlob("image")));

            }
            // Release connection
            DBManager.getInstance().releaseConnection(conn);

        } catch (SQLException | IOException e) {
            throw new DatabaseException(e.getMessage(), e);
        }

        return product;
    }

    public boolean addProduct(String name, String description, double price, int quantity, InputStream image) throws DatabaseException {


        boolean success= false;

        try{
            // Acquire connection
            DBManager db = DBManager.getInstance();
            Connection conn = db.getConnection();
            String t_product_sql = "insert into t_products (name, description, quantity, price, image) values (?, ?, ?, ?, ?)";

            // Start transaction
            db.startTransaction(conn);

            // Insert to t_products table
            PreparedStatement preparedStatement = conn.prepareStatement(t_product_sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setDouble(4, price);
            preparedStatement.setBlob(5, image);
            int result = preparedStatement.executeUpdate();
            if(result > 0){
                success = true;
                db.commitTransaction(conn);
            }

            // Release connection
            db.releaseConnection(conn);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(),e);
        }

        return success;
    }

    private String getBase64Image(Blob blob) throws SQLException, IOException {
        InputStream inputStream = blob.getBinaryStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
        }
        byte[] imageBytes = byteArrayOutputStream.toByteArray();

        return Base64.getEncoder().encodeToString(imageBytes);
    }

}
