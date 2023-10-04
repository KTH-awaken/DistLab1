<%@ page import="com.example.distlab1.BO.Entities.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: hamadaaljarrah
  Date: 2023-10-02
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <style ><jsp:directive.include file="styles.css"/></style>
</head>
    <body class="page">
        <jsp:include page="navbar.jsp"></jsp:include>
        <div class="welcome-text">
            <h2>
                Store.<span style="color: #6e6e73"> Det bästa stället att <br/>
                köpa dina favoritprodukter.</span>
            </h2>
        </div>
        <div class="products-container">
            <%
                Object data = request.getAttribute("products");
                if (data !=null) {
                    ArrayList<Product> products = (ArrayList<Product>) data;
                    for (Product product : products) {
            %>
                <a href="product-detail?id=<%=product.getId()%>">

                    <img class="product-image" src="data:image/jpg;base64,<%=product.getBase64Image()%>">
                        <div class="product-text">
                            <p><%=product.getName()%></p>
<%--                            <p><%=product.getDescription()%></p>--%>
                            <p>Från <%= new DecimalFormat("0").format(product.getPrice()) %> kr</p>
                        </div>
                </a>
            <%
                    }
                }
                %>

        </div>
    </body>
</html>
