package com.example.distlab1.UI.Controllers;

import com.example.distlab1.BO.Handlers.ProductHandler;
import com.example.distlab1.DB.DatabaseException;
import com.example.distlab1.UI.Error.UIErrorHandler;
import com.example.distlab1.UI.DTOs.ProductDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/cart", "/add-to-cart", "/delete-from-cart"})
public class CartServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String action = req.getRequestURI();
        switch (action){
            case "/cart":
                req.getRequestDispatcher("/cart.jsp").forward(req,res);
                break;
            case "/delete-from-cart":
                break;
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            String action = req.getRequestURI();
            switch (action){
                case "/add-to-cart":
                addToCart(req, res);
                break;
                case "/remove-from-cart":
                    removeFromCart(req, res);
                    break;
            }


    }

    private void removeFromCart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

    }
    private void addToCart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int productId = Integer.parseInt(req.getParameter("id"));

        ArrayList<ProductDTO> cart = new ArrayList<>();
        ArrayList<ProductDTO> previousCart =  (ArrayList<ProductDTO>) session.getAttribute("cart");

        if(previousCart != null){
            cart = new ArrayList<>(previousCart);
        }

        try {
            ProductDTO addedProduct = ProductHandler.getProductById(productId);
            cart.add(addedProduct);
            session.setAttribute("cart", cart);
            session.setAttribute("numOfCartItems", cart.size());
            res.sendRedirect("/product-detail?id="+productId);
        } catch (DatabaseException e){
            UIErrorHandler.handleDatabaseException(req ,res, e);
        }


    }
}
