package com.example.distlab1.UI.Controllers;

import com.example.distlab1.BO.Handlers.ProductHandler;
import com.example.distlab1.DB.DatabaseException;
import com.example.distlab1.UI.Error.UIErrorHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;


@WebServlet({"/admin/add-product", "/admin/edit-product"})
@MultipartConfig
public class ManageProductServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String action = req.getServletPath();

        switch (action){
            case "/admin/add-product":
                req.getRequestDispatcher("/product-form.jsp").forward(req, res);
                break;
            case "/admin/edit-product":
                editProduct(req, res);
                break;
            default:
                req.getRequestDispatcher("/").forward(req,res);
        }



    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        String action = req.getServletPath();

        switch (action){
            case "/admin/add-product":
                addProduct(req, res);
                break;
            case "/admin/edit-product":
                editProduct(req, res);
                break;
            default:
                req.getRequestDispatcher("/").forward(req,res);
        }


    }


    private void addProduct(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
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
            ProductHandler.addProduct(name,description,price,quantity,inputStream);
            res.sendRedirect("/products");

        } catch (DatabaseException e) {
            UIErrorHandler.handleDatabaseException(req,res,e);
        }
    }

    private void editProduct(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        System.out.println("editing product...");
    }

}
