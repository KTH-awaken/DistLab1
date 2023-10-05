
<%@ page import="com.example.distlab1.UI.DTOs.ProductDTO" %><%--
  Created by IntelliJ IDEA.
  User: hamadaaljarrah
  Date: 2023-10-02
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product detail</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

<%
    Object data = request.getAttribute("product");
    ProductDTO product = (ProductDTO) data;
 %>

<div class="p-4 rounded-lg shadow-lg w-[600px]">
    <img class="product-image h-[400px] w-full object-cover" src="data:image/jpg;base64,<%=product.getBase64Image()%>">
    <div>
        <h2><%= product.getName()%></h2>
        <h4>Quantity: <%= product.getQuantity()%></h4>
        <br>
        <h5>Description</h5>
        <p><%= product.getDescription()%></p>

        <h5>Price: <%= product.getPrice()%></h5>
    </div>


</div>


</body>
</html>
