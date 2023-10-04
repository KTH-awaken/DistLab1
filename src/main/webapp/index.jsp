<%@ page import="com.example.distlab1.BO.Entities.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
<%--        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/styles.css">--%>
        <style ><jsp:directive.include file="styles.css"/></style>
        <script src="https://cdn.tailwindcss.com"></script>


    </head>
    <body class="page">
        <jsp:include page="navbar.jsp"></jsp:include>

        <div class="welcome-text">
            <h2>
                Store.<span style="color: #6e6e73"> Det bästa stället att <br/>
                köpa dina favoritprodukter.</span>
            </h2>
        </div>
            <br/>
        <div style="background-color: red">

        <%
            Object data = request.getAttribute("products");
            if (data !=null) {
                ArrayList<Product> products = (ArrayList<Product>) data;
                for (Product product : products) {
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
        </div>
    </body>
</html>