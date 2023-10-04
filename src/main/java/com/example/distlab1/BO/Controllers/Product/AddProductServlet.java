package com.example.distlab1.BO.Controllers.Product;

import com.example.distlab1.BO.Entities.User;
import com.example.distlab1.BO.Error.ErrorHandler;
import com.example.distlab1.DB.DAO.Implementation.ProductDAO;
import com.example.distlab1.DB.Database.DatabaseException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.InputStream;


@WebServlet("/admin/add-product")
@MultipartConfig
public class AddProductServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        // Serv product-form page
        RequestDispatcher dispatcher = req.getRequestDispatcher("product-form.jsp");
        dispatcher.forward(req, res);

    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {



        // Get user inputs
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Integer.parseInt(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        // Get upload image.
        Part part = req.getPart("image");
        InputStream inputStream = part.getInputStream();

        try {
            // Create product
            new ProductDAO().addProduct(name,description,price,quantity,inputStream);
            res.sendRedirect("products");

        } catch (DatabaseException e) {
            ErrorHandler.handleDatabaseException(req,res,e);
        }


    }




}
