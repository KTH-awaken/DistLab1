//package com.example.distlab1.Filters;
//
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//
//@WebFilter(
//        urlPatterns = {"/placer-order", "/cart", "/add-to-cart", "/delete-from-cart"},
//        filterName = "only-authenticated-user-filter"
//)
//public class AuthenticatedFilter implements Filter {
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//
//
//        HttpSession session = req.getSession(false);
//        System.out.println("Filter: " + session.getAttribute("user"));
//
//        if(session.getAttribute("user") != null){
//            chain.doFilter(request,response);
//        } else {
//            res.sendRedirect("/login.jsp");
//        }
//
//
//
//    }
//}
