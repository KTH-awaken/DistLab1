package com.example.distlab1.UI.Controllers;

import com.example.distlab1.BO.Handlers.OrderHandler;
import com.example.distlab1.UI.DTOs.OrderDTO;
import com.example.distlab1.UI.DTOs.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/warehouse/pack","/warehouse/show-orders"})//todo kolla om det går att ta bort warehouser från strigen
public class packServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<OrderDTO> orders = OrderHandler.getOrders();
        req.setAttribute("orders",orders);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pack.jsp");
//        dispatcher.forward(req, res);//todo kolla om den här behövs
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        pack(req,res);
    }
    private void pack(HttpServletRequest req, HttpServletResponse res){
        //tood målet är att order fufile = true
        req.getParameter("id");
        HttpSession session = req.getSession();
        UserDTO user = (UserDTO)session.getAttribute("user");
        int id = user.getId();
//        OrderDTO orderDTO = session.getAttribute("order")
//        req.
//        OrderHandler.packOrder(id,);
    }
}