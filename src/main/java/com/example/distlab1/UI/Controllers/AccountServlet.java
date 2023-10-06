package com.example.distlab1.UI.Controllers;



import com.example.distlab1.BO.Handlers.UserHandler;
import com.example.distlab1.DB.DatabaseException;
import com.example.distlab1.UI.Error.UIErrorHandler;
import com.example.distlab1.UI.DTOs.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/login", "/sign-up", "/logout"})
public class AccountServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String action = req.getServletPath();


        switch (action){
            case "/login":
                req.getRequestDispatcher("/login.jsp").forward(req,res);
                break;
            case  "/sign-up":
                req.getRequestDispatcher("/sign-up.jsp").forward(req,res);
                break;
            default:
                req.getRequestDispatcher("/index.jsp").forward(req, res);
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action){
            case "/login":
                login(req,res);
                break;
            case  "/sign-up":
                register(req,res);
                break;
            case  "/logout":
                logout(req, res);
                break;
            default:
                return;
        }

    }


    private void register(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
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
    private void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            UserDTO user = UserHandler.handleLogin(email, password);
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
    private void logout(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        UserDTO user = (UserDTO) session.getAttribute("user");
        if (user != null) {
            session.invalidate();
            req.getRequestDispatcher("/login").forward(req, res);
        }
    }

}
