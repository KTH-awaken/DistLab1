<%@ page import="com.example.distlab1.UI.DTOs.ProductDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<html>

<head>
    <title>Success</title>
    <style><jsp:directive.include file="styles.css" /></style>

</head>

<body class="page">
<jsp:include page="navbar.jsp"></jsp:include>
    <div class="parent">
            <h1 style="font-size: 30px;margin-top: 100px">Tack för din beställning!</h1>
                <br>
            <h3>Orderdetaljer</h3>
        <br>
        <div>
            <% Object data=request.getAttribute("order-products"); if (data !=null) { ArrayList<ProductDTO> products =
                (ArrayList<ProductDTO>) data;
                    for (ProductDTO product : products) {
                    %>
                        <div class="product-text2">
                            <%=product.getName()%> Pris <%= new DecimalFormat("0").format(product.getPrice()) %> kr</>
                        </div>
                    <% } } %>
        </div>
    </div>
</body>

</html>