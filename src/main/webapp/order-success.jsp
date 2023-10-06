<%@ page import="com.example.distlab1.UI.DTOs.ProductDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<html>

<head>
    <title>Success</title>
</head>

<body class="page">
    <div class="parent">
        <h1>Order succeed!</h1>
        <h3>Details</h3>
        <div>
            <% Object data=request.getAttribute("order-products"); if (data !=null) { ArrayList<ProductDTO> products =
                (ArrayList<ProductDTO>) data;
                    for (ProductDTO product : products) {
                    %>
                    <a href="product-detail?id=<%=product.getId()%>">
                        <div class="product-text">
                            <p>
                                <%=product.getName()%>
                            </p>
                            <p>Från <%= new DecimalFormat("0").format(product.getPrice()) %> kr</p>
                        </div>
                    </a>
                    <% } } %>
        </div>
    </div>
</body>

</html>