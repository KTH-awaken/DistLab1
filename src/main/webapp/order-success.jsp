<%--<%@ page import="java.util.ArrayList" %>--%>
<%--<%@ page import="com.example.distlab1.UI.DTOs.ProductDTO" %>--%>
<%--<%@ page import="java.text.DecimalFormat" %>&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: hamadaaljarrah--%>
<%--  Date: 2023-10-05--%>
<%--  Time: 13:13--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<style ><jsp:directive.include file="styles.css"/></style>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Success</title>--%>
<%--</head>--%>
<%--<body class="page">--%>
<%--    <div class="parent">--%>
<%--        <h1>Order succeed!</h1>--%>
<%--        <h3>Details</h3>--%>
<%--        <div>--%>
<%--            <%--%>
<%--                Object data = request.getAttribute("products");--%>
<%--                if (data !=null) {--%>
<%--                    ArrayList<ProductDTO> products = (ArrayList<ProductDTO>) data;--%>
<%--                    for (ProductDTO product : products) {--%>
<%--            %>--%>

<%--                <img class="product-image" src="data:image/jpg;base64,<%=product.getBase64Image()%>">--%>
<%--                <div class="product-text">--%>
<%--                    <p><%=product.getName()%></p>--%>
<%--                    <p>Från <%= new DecimalFormat("0").format(product.getPrice()) %> kr</p>--%>
<%--                </div>--%>
<%--            </a>--%>
<%--            <%--%>
<%--                    }--%>
<%--                }--%>
<%--            %>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.distlab1.UI.DTOs.ProductDTO" %>
<%@ page import="java.text.DecimalFormat" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%-- Include your CSS styles here --%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.example.distlab1.UI.DTOs.ProductDTO" %>
    <%@ page import="java.text.DecimalFormat" %>
</style>

<html>
<head>
    <title>Success</title>
</head>
<body class="page">
<div class="parent">
    <h1>Order succeed!</h1>
    <h3>Details</h3>
    <div>
        <%
            Object data = request.getAttribute("order-products");
            if (data != null) {
                ArrayList<ProductDTO> products = (ArrayList<ProductDTO>) data;
                for (ProductDTO product : products) {
        %>
        <a href="product-detail?id=<%=product.getId()%>">
            <div class="product-text">
                <p><%=product.getName()%></p>
                <p>Från <%= new DecimalFormat("0").format(product.getPrice()) %> kr</p>
            </div>
        </a>
        <%
                }
            }
        %>
    </div>
</div>
</body>
</html>
