package com.example.distlab1.BO.Handlers;

import com.example.distlab1.DB.DatabaseException;
import com.example.distlab1.UI.DTOs.ProductDTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrderHandler {

    static public void placeOrder(int userid, ArrayList<ProductDTO> products) throws DatabaseException {
        DBContext db = new DBContext();
        ArrayList<Integer> ids = mapProductIds(products);
        System.out.println(userid + " " +  ids);
        db.order().insertOrder(userid, ids);
    }

    static private ArrayList<Integer> mapProductIds(ArrayList<ProductDTO> products){
        return products.stream().map(ProductDTO::getId).collect(Collectors.toCollection(ArrayList::new));
    }
}
