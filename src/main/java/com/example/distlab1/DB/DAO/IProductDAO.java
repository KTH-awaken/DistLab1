package com.example.distlab1.DB.DAO;

import com.example.distlab1.BO.Entities.Product;
import com.example.distlab1.DB.Database.DatabaseException;

import java.io.InputStream;
import java.util.List;

public interface IProductDAO {



    List<Product> getAllProducts() throws DatabaseException;
    Product getProductById(int id) throws DatabaseException;
    boolean addProduct(String name, String description, double price, int quantity, InputStream image) throws DatabaseException;
    Product updateProductById(int id, Product updated);
    Product deleteProductById(int id);




}
