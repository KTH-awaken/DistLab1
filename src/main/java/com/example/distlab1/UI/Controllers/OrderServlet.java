package com.example.distlab1.UI.Controllers;

import com.example.distlab1.BO.Handlers.OrderHandler;
import com.example.distlab1.DB.DatabaseException;
import com.example.distlab1.UI.Error.UIErrorHandler;
import com.example.distlab1.UI.DTOs.ProductDTO;
import com.example.distlab1.UI.DTOs.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/place-order"})
public class OrderServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {



    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getRequestURI();
        switch (action){

            case "/place-order":
                placeOrder(req, res);
                break;
            default:
                break;
        }


    }

    private void placeOrder(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        HttpSession session = req.getSession();
        UserDTO user = (UserDTO)session.getAttribute("user");
        ArrayList<ProductDTO> products = (ArrayList<ProductDTO>) session.getAttribute("cart");
        System.out.println("User: "+ user);
        System.out.println("Products: " + products);
        int id = user.getId();
        try {
            OrderHandler.placeOrder(id, products);
            req.getRequestDispatcher("/order-success.jsp").forward(req,res);
        }catch (DatabaseException e){
            UIErrorHandler.handleDatabaseException(req, res, e);
        }
    }

}
