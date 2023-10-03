package com.example.distlab1.BO.Controllers;

import com.example.distlab1.BO.Entities.Product;
import com.example.distlab1.BO.Services.Imlementations.ProductService;
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

        // Get product
        Product product = new ProductService().getProductById(id);

        req.setAttribute("product", product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product-detail.jsp");
        dispatcher.forward(req, res);
    }
}
