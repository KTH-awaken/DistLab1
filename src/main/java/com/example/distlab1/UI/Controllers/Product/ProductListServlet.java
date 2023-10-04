package com.example.distlab1.UI.Controllers.Product;


import com.example.distlab1.BO.Handlers.ProductHandler;
import com.example.distlab1.DB.DatabaseException;
import com.example.distlab1.UI.Error.UIErrorHandler;
import com.example.distlab1.UI.ItemInfo.ProductInto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/products")
public class ProductListServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try {

            ArrayList<ProductInto> products = ProductHandler.getProducts();
            req.setAttribute("products", products);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/products.jsp");
            dispatcher.forward(req, res);

        } catch (DatabaseException e) {
            UIErrorHandler.handleDatabaseException(req, res,e);
        }


    }



}
