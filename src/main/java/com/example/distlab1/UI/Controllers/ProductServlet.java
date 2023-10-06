package com.example.distlab1.UI.Controllers;


import com.example.distlab1.BO.Handlers.ProductHandler;
import com.example.distlab1.DB.DatabaseException;
import com.example.distlab1.UI.Error.UIErrorHandler;
import com.example.distlab1.UI.DTOs.ProductDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/products", "/product-detail"})
public class ProductServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getRequestURI();

        switch (action){
            case "/product-detail":
                showProductDetails(req, res);
                break;
            case  "/products":
                showProducts(req, res);
                break;

            default:
                req.getRequestDispatcher("/").forward(req, res);
        }

    }






    private void showProducts(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        try {

            ArrayList<ProductDTO> products = ProductHandler.getProducts();
            req.setAttribute("products", products);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/products.jsp");
            dispatcher.forward(req, res);

        } catch (DatabaseException e) {
            UIErrorHandler.handleDatabaseException(req, res,e);
        }

    }


    private void showProductDetails(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            ProductDTO product = ProductHandler.getProductById(id);
            req.setAttribute("product", product);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/product-detail.jsp");
            dispatcher.forward(req, res);

        } catch (DatabaseException e) {
            UIErrorHandler.handleDatabaseException(req, res,e);
        }
    }



}
