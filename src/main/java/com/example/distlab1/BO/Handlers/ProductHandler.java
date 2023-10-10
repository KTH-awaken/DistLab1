package com.example.distlab1.BO.Handlers;

import com.example.distlab1.BO.Entities.Product;
import com.example.distlab1.DB.DatabaseException;
import com.example.distlab1.UI.DTOs.ProductDTO;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;

public class ProductHandler {
    /**
     * Adds a new product to the database.
     * @param name The name of the product.
     * @param description The description of the product.
     * @param price The price of the product.
     * @param quantity The quantity of the product in stock.
     * @param image The image of the product.
     * @throws DatabaseException If an error occurs while adding the product to the database.
     */

    static public void addProduct(String name, String description, double price, int quantity, InputStream image) throws DatabaseException {
        DBContext db = new DBContext();
        db.product().insertProduct(name, description,price,quantity,image);
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

    static public void updateProduct(int id, ProductDTO newValues, InputStream image) throws DatabaseException{
        DBContext db = new DBContext();
        db.product().updateProduct(id,
                newValues.getName(),
                newValues.getDescription(),
                newValues.getPrice(),
                newValues.getQuantity(),
                image);

    }
    static public void deleteProduct(int id) throws DatabaseException{
        DBContext db = new DBContext();
        db.product().deleteProduct(id);

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
