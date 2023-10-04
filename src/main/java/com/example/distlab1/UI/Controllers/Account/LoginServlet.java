package com.example.distlab1.UI.Controllers.Account;



import com.example.distlab1.BO.Handlers.UserHandler;
import com.example.distlab1.DB.DatabaseException;
import com.example.distlab1.UI.Error.UIErrorHandler;
import com.example.distlab1.UI.ItemInfo.UserInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.getRequestDispatcher("/login.jsp").forward(req,res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            UserInfo user = UserHandler.handleLogin(email, password);
            if(user != null){
                // Success login
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                // Expiration 3days
                session.setMaxInactiveInterval(3 * 24 * 60 * 60);
                req.getRequestDispatcher("/index.jsp").forward(req,res);
            } else {
                String alert = "<div class=\"p-4 bg-red-500/30 text-red-500 rounder-md \">\n" +
                        "          <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                        "             Wrong email or password!\n" +
                        "          </p>\n" +
                        "       </div>";
                req.setAttribute("alert", alert);
                req.getRequestDispatcher("/login.jsp").forward(req, res);
            }

        } catch (DatabaseException e) {
            UIErrorHandler.handleDatabaseException(req, res,e);
        }

    }
}
