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

@WebServlet("/product-detail")
public class ProductDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Product  product = new ProductDAO().getProductById(id);
            req.setAttribute("product", product);
            RequestDispatcher dispatcher = req.getRequestDispatcher("product-detail.jsp");
            dispatcher.forward(req, res);

        } catch (DatabaseException e) {
            ErrorHandler.handleDatabaseException(req, res,e);
        }

    }



}
