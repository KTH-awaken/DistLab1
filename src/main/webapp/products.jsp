<%@ page import="com.example.distlab1.UI.DTOs.ProductDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <style ><jsp:directive.include file="styles.css"/></style>
</head>
    <body class="page">
        <jsp:include page="/navbar.jsp"></jsp:include>

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
                    ArrayList<ProductDTO> products = (ArrayList<ProductDTO>) data;
                    for (ProductDTO product : products) {
            %>
                <a href="product-detail?id=<%=product.getId()%>">

                    <img class="product-image" src="data:image/jpg;base64,<%=product.getBase64Image()%>">
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
    </body>
</html>
