<%--
  Created by IntelliJ IDEA.
  User: Marcus
  Date: 2023-10-02
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
<div class="topnav">
    <a class="<%= request.getRequestURI().endsWith("index.jsp") ? "active" : "" %>" href="/">Hem</a>
    <a class="<%= request.getRequestURI().endsWith("login.jsp") ? "active" : "" %>" href="/login">Logga in</a>
    <a class="<%= request.getRequestURI().endsWith("login.jsp") ? "active" : "" %>" href="/admin/add-product">Lägg till produkt</a>
    <a class="<%= request.getRequestURI().endsWith("login.jsp") ? "active" : "" %>" href="/products">All produkter</a>
    <a class="<%= request.getRequestURI().endsWith("login.jsp") ? "active" : "" %>" href="/cart">cart</a>

</div>
</body>
</html>
