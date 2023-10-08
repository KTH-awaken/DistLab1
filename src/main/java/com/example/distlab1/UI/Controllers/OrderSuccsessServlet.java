package com.example.distlab1.UI.Controllers;

import com.example.distlab1.UI.DTOs.OrderDTO;
import com.example.distlab1.UI.DTOs.ProductDTO;
import com.example.distlab1.UI.DTOs.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/order-success"})
public class OrderSuccsessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        showOrderSuccess(req,res);
//        res.sendRedirect("/order-success.jsp");
    }

    private void showOrderSuccess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDTO user = (UserDTO)session.getAttribute("user");
        ArrayList<ProductDTO> products = (ArrayList<ProductDTO>) session.getAttribute("cart");
        req.setAttribute("order-products",products);
        req.getRequestDispatcher("order-success.jsp").forward(req,res);
//        //todo här mapar jag om products till en order sen aropar jag pack servlert
//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setUserId(user.getId());


    }
}
