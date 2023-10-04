package com.example.distlab1.BO.Controllers.Product;


import com.example.distlab1.BO.Entities.Product;
import com.example.distlab1.BO.Error.ErrorHandler;
import com.example.distlab1.DB.DAO.Implementation.ProductDAO;
import com.example.distlab1.DB.Database.DatabaseException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductListServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        try {

            List<Product> products = new ProductDAO().getAllProducts();
            req.setAttribute("products", products);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/products.jsp");
            dispatcher.forward(req, res);

        } catch (DatabaseException e) {
            ErrorHandler.handleDatabaseException(req, res,e);
        }


    }



}
