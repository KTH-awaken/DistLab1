package com.example.distlab1.UI.Error;

import com.example.distlab1.DB.DatabaseException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UIErrorHandler {

    public static void handleDatabaseException(HttpServletRequest req, HttpServletResponse res, DatabaseException e) throws ServletException, IOException {
        String errorMessage = "An error occurred: " + e.getMessage();
        req.setAttribute("errorMessage", errorMessage);
        req.setAttribute("try-url", req.getRequestURI());
        res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
        dispatcher.forward(req, res);
    }



}
