package com.example.distlab1.DB.DAO;

import com.example.distlab1.BO.Entities.ActionResult;
import com.example.distlab1.BO.Entities.Product;
import com.example.distlab1.DB.Database.DatabaseException;

public interface ICartDAO {


    ActionResult<Product> addToCart(int userId, int productId) throws DatabaseException;
    ActionResult<Product> removeFromCart(int userId, int productId) throws DatabaseException;

}
