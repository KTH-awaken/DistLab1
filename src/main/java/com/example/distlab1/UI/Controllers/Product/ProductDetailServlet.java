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

@WebServlet("/product-detail")
public class ProductDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            ProductInto product = ProductHandler.getProductById(id);
            req.setAttribute("product", product);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/product-detail.jsp");
            dispatcher.forward(req, res);

        } catch (DatabaseException e) {
            UIErrorHandler.handleDatabaseException(req, res,e);
        }

    }



}
