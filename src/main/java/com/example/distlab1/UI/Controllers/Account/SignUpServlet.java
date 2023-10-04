package com.example.distlab1.UI.Controllers.Account;



import com.example.distlab1.BO.Handlers.UserHandler;
import com.example.distlab1.DB.DatabaseException;
import com.example.distlab1.UI.Error.UIErrorHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.getRequestDispatcher("/sign-up.jsp").forward(req,res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            boolean result = UserHandler.registerUser(username,email,password);
            if(result){
                res.sendRedirect("/login");
            } else {
                String alert = "<div class=\"p-4 bg-red-500/30 text-red-500 rounder-md \">\n" +
                        "          <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                        "             Given email is already in use!\n" +
                        "          </p>\n" +
                        "       </div>";
                req.setAttribute("alert", alert);
                req.getRequestDispatcher("/sign-up.jsp").forward(req, res);
            }

        } catch (DatabaseException e) {
            UIErrorHandler.handleDatabaseException(req, res,e);
        }


    }
}
