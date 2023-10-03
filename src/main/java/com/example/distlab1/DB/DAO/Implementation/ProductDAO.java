package com.example.distlab1.DB.DAO.Implementation;

import com.example.distlab1.DB.DAO.IProductDAO;
import com.example.distlab1.BO.Entities.Product;
import com.example.distlab1.DB.DAO.IProductDAO;
import com.example.distlab1.DB.Database.DatabaseConnection;
import com.example.distlab1.DB.Database.DatabaseException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ProductDAO implements IProductDAO {


    public ProductDAO() {
    }

    @Override
    public List<Product> getAllProducts() throws DatabaseException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM t_products";

        try {
            // Acquire connection
            Connection conn = DatabaseConnection.getInstance().getConnection();
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
            DatabaseConnection.getInstance().releaseConnection(conn);
        } catch (SQLException | IOException | DatabaseException e) {
            throw new DatabaseException();
        }

        return products;
    }

    @Override
    public Product getProductById(int id) throws DatabaseException {
        Product product = new Product();
        String sql = "select * from t_products where id = " + id;

        try {
            // Acquire connection
            Connection conn = DatabaseConnection.getInstance().getConnection();
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
            DatabaseConnection.getInstance().releaseConnection(conn);

        } catch (SQLException | IOException e) {
            throw new DatabaseException(e.getMessage(), e);
        }


        return product;
    }

    @Override
    public boolean addProduct(String name, String description, double price, int quantity, InputStream image) throws DatabaseException{


        boolean success= false;

        try{
            // Acquire connection
            Connection conn = DatabaseConnection.getInstance().getConnection();
            String t_product_sql = "insert into t_products (name, description, quantity, price, image) values (?, ?, ?, ?, ?)";

            // Start transaction
            conn.setAutoCommit(false);

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
                conn.commit();
            }

            // End transaction
            conn.setAutoCommit(true);

            // Release connection
            DatabaseConnection.getInstance().releaseConnection(conn);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(),e);
        }

        return success;
    }

    @Override
    public Product updateProductById(int id, Product updated) {
        return null;
    }

    @Override
    public Product deleteProductById(int id) {
        return null;
    }




    // Method to get blob image from database.
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


    public static void main(String[] args) throws DatabaseException {
        IProductDAO test = new ProductDAO();
//        System.out.println(test.getAllProducts());
//        byte[] data = "dummy image.".getBytes();
//        InputStream inputStream = new ByteArrayInputStream(data);
//        test.addProduct("Mikael", "Description", 99.99, 99,inputStream );
        System.out.println(test.getAllProducts());
    }


}
