package com.example.distlab1.BO.Handlers;

import com.example.distlab1.BO.Entities.Order;
import com.example.distlab1.DB.DatabaseException;
import com.example.distlab1.UI.DTOs.OrderDTO;
import com.example.distlab1.UI.DTOs.ProductDTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrderHandler {
    /**
     * Places an order for the specified user and products.
     * @param userid The ID of the user placing the order.
     * @param products The products included in the order.
     * @throws DatabaseException If an error occurs while placing the order.
     */
    static public void placeOrder(int userid, ArrayList<ProductDTO> products) throws DatabaseException {
        DBContext db = new DBContext();
        ArrayList<Integer> ids = mapProductIds(products);
        db.order().insertOrder(userid, ids);
    }

    static private ArrayList<Integer> mapProductIds(ArrayList<ProductDTO> products){
        return products.stream().map(ProductDTO::getId).collect(Collectors.toCollection(ArrayList::new));
    }

    static public void packOrder(int id) throws DatabaseException {
        //todo här packar vi sedan den valda unfuild order i listan
        DBContext db = new DBContext();
        db.order().updateOrder(id,"pack");

    }

    static public ArrayList<OrderDTO> getOrders(){
        DBContext db = new DBContext();
        ArrayList<OrderDTO> ordersToReturn= new ArrayList<>();
        ArrayList<Order> orders = db.order().getOrders();

        for (Order o:orders) {
            ordersToReturn.add(mapOrder(o));
        }
        return ordersToReturn;
    }

    private static OrderDTO mapOrder(Order o){
        OrderDTO orderToReturn = new OrderDTO();
        orderToReturn.setId(o.getId());
        orderToReturn.setUserId(o.getUserId());
        orderToReturn.setFulfilled(o.isFulfilled());
        return orderToReturn;
    }
}
