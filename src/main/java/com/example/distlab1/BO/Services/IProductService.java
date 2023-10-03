package com.example.distlab1.BO.Services;

import com.example.distlab1.BO.Entities.Product;

import java.io.InputStream;
import java.util.List;

public interface IProductService {

    boolean addProduct(String name, String description, double price, int quantity, InputStream image);
    Product getProductById(int id);

    List<Product> getAllProducts();
}
