package com.example.distlab1.BO.Handlers;

import com.example.distlab1.BO.Entities.Product;
import com.example.distlab1.DB.DatabaseException;
import com.example.distlab1.UI.DTOs.ProductDTO;

import java.io.InputStream;
import java.util.ArrayList;

public class ProductHandler {


    static public void addProduct(String name, String description, double price, int quantity, InputStream image) throws DatabaseException {
        DBContext db = new DBContext();
        db.product().addProduct(name, description,price,quantity,image);
    }

    static public ProductDTO getProductById(int id) throws DatabaseException{
        DBContext db = new DBContext();
        return mapProduct(db.product().getProductById(id));

    }

    static public ArrayList<ProductDTO> getProducts() throws DatabaseException{
        DBContext db = new DBContext();
        ArrayList<ProductDTO> productsToReturn = new ArrayList<>();
        ArrayList<Product> ps = db.product().getProducts();

        for(Product p:ps )
            productsToReturn.add(mapProduct(p));

        return productsToReturn;
    }


    private static ProductDTO mapProduct(Product p){
        ProductDTO productToReturn = new ProductDTO();
        productToReturn.setId(p.getId());
        productToReturn.setName(p.getName());
        productToReturn.setDescription(p.getDescription());
        productToReturn.setQuantity(p.getQuantity());
        productToReturn.setPrice(p.getPrice());
        productToReturn.setBase64Image(p.getBase64Image());
        return productToReturn;
    }
}
