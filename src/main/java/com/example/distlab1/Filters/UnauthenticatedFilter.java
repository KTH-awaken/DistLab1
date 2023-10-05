//package com.example.distlab1.Filters;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//
//@WebFilter(
//        urlPatterns = {"/login", "/sign-up"},
//        filterName = "login-sign-up-filter"
//)
//public class UnauthenticatedFilter implements Filter {
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//
//        HttpSession session = req.getSession(false);
//
//        if(session.getAttribute("user") == null){
//            chain.doFilter(request,response);
//        }
//
//
//
//    }
//}
