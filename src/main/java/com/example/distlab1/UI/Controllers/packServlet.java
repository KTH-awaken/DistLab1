package com.example.distlab1.UI.Controllers;

import com.example.distlab1.BO.Handlers.OrderHandler;
import com.example.distlab1.DB.DatabaseException;
import com.example.distlab1.UI.DTOs.OrderDTO;
import com.example.distlab1.UI.DTOs.UserDTO;
import com.example.distlab1.UI.Error.UIErrorHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/pack")

//@WebServlet({"/warehouse/pack","/warehouse/show-orders"})//todo kolla om det går att ta bort warehouser från strigen
public class packServlet extends HttpServlet {

//    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        ArrayList<OrderDTO> orders = OrderHandler.getOrders();
//        req.setAttribute("orders",orders);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/pack.jsp");
//        dispatcher.forward(req, res);//todo kolla om den här behövs
//        System.out.println(orders);
//        System.out.println("^^");
//    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ArrayList<OrderDTO> orders = OrderHandler.getOrders();
    request.setAttribute("orders", orders);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/pack.jsp");
    dispatcher.forward(request, response);

}

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try {
            pack(req,res);
        } catch (DatabaseException e) {
            throw new RuntimeException(e);
        }
    }
    private void pack(HttpServletRequest req, HttpServletResponse res) throws IOException, DatabaseException {
        //tood målet är att order fufile = true
        int orderId = Integer.parseInt(req.getParameter("id"));
        OrderHandler.packOrder(orderId);
        res.sendRedirect("/pack");//todo ckek if needed

    }
}