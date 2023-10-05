<%@ page import="com.example.distlab1.UI.DTOs.ProductDTO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: hamadaaljarrah
  Date: 2023-10-04
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>


<h1>My Cart</h1>
<form action="place-order" method="post">
  <button>Place order</button>
</form>
<%
  Object data = request.getAttribute("cart");
  if (data !=null) {
    ArrayList<ProductDTO> products = (ArrayList<ProductDTO>) data;
    for (ProductDTO product : products) {
%>

<div class="p-4 rounded-lg shadow-lg w-[300px]">
  <img class="product-image h-[200px] w-full object-cover" src="data:image/jpg;base64,<%=product.getBase64Image()%>">
  <div>
    <a href="product-detail?id=<%=product.getId()%>"><%= product.getName()%></a>
    <p>Price: <%= product.getPrice()%> kr</p>
  </div>
</div>
<%
    }
  }
%>

</body>
</html>
