package com.example.distlab1.Filters;

import com.example.distlab1.UI.DTOs.UserDTO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(
        urlPatterns = {"/admin/*"},
        filterName = "AdminAuthenticationFilter"
)
public class AdminAuthFilter implements Filter {


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        if(session == null){
            req.getRequestDispatcher("/login.jsp").forward(req,res);
            return;
        }


        UserDTO user = (UserDTO) session.getAttribute("user");
        if(user == null){
            req.getRequestDispatcher("/login.jsp").forward(req,res);
            return;
        }


        if(user.getRole().compareTo("admin") == 0){
            // User is authenticated
            chain.doFilter(request,response);
        } else {
            req.getRequestDispatcher("/access-denied.jsp").forward(req,res);
        }

    }


}