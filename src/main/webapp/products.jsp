<%--<%@ page import="com.example.distlab1.UI.DTOs.ProductDTO" %>--%>
<%--<%@ page import="java.util.ArrayList" %>--%>
<%--<%@ page import="java.text.DecimalFormat" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>

<%--<head>--%>
<%--    <title>Products</title>--%>
<%--    <style>--%>
<%--        <jsp:directive.include file="styles.css"/>--%>
<%--    </style>--%>
<%--</head>--%>

<%--<body class="page">--%>
<%--<jsp:include page="/navbar.jsp"></jsp:include>--%>
<%--<div class="layout-container">--%>
<%--    <div class="welcome-text">--%>
<%--        <h2 class="my-4">Store.<span--%>
<%--                style="color: #6e6e73"> Det bästa stället att <br/>köpa dina favoritprodukter.</span></h2>--%>
<%--    </div>--%>
<%--    <div--%>
<%--            class="flex flex-row ">--%>
<%--        <% Object data = request.getAttribute("products");--%>
<%--            if (data != null) {--%>
<%--                ArrayList<ProductDTO> products = (ArrayList<ProductDTO>) data;--%>
<%--                for (int i = 0; i < products.size(); i++) {--%>
<%--                    ProductDTO product = products.get(i);%>--%>
<%--        <div--%>
<%--                class="product-item">--%>
<%--            <a--%>
<%--                    href="product-detail?id=<%=product.getId()%>">--%>
<%--                <img class="product-image"--%>
<%--                     src="data:image/jpg;base64,<%=product.getBase64Image()%>"--%>
<%--                     onload="setTextColor(this, <%= i %>);">--%>
<%--                <!-- Pass index for each image -->--%>
<%--                <span--%>
<%--                        class="product-text"--%>
<%--                        id="productText<%= i %>">--%>
<%--                <p>--%>
<%--            <%=product.getName()%>--%>
<%--            </p>--%>
<%--            <p>Från--%>
<%--            <%= new--%>
<%--                    DecimalFormat("0").format(product.getPrice())--%>
<%--            %>--%>
<%--                kr--%>
<%--            </p>--%>
<%--            </span>--%>
<%--            </a>--%>
<%--        </div>--%>
<%--        <% }--%>
<%--        }--%>
<%--        %>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</body>--%>


<%--</html>--%>
<%@ page import="com.example.distlab1.UI.DTOs.ProductDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Products</title>
    <style>
        <jsp:directive.include file="styles.css"/>
    </style>
</head>

<body class="page">
<jsp:include page="/navbar.jsp"></jsp:include>
<div class="layout-container">
    <div class="welcome-text">
        <h2 class="my-4">Store.<span
                style="color: #6e6e73"> Det bästa stället att <br/>köpa dina favoritprodukter.</span></h2>
    </div>
    <div class="flex flex-row">
        <%
            Object data = request.getAttribute("products");
            if (data != null) {
                ArrayList<ProductDTO> products = (ArrayList<ProductDTO>) data;
                for (int i = 0; i < products.size(); i++) {
                    ProductDTO product = products.get(i);
        %>
        <div class="product-item">
            <a href="product-detail?id=<%=product.getId()%>">
                <img class="product-image" src="data:image/jpg;base64,<%=product.getBase64Image()%>"
                     onload="setTextColor(this, <%= i %>);"> <!-- Pass index for each image -->
                <span class="product-text" id="productText<%= i %>"> <!-- Unique ID for each product text -->
                    <p><%=product.getName()%></p>
                    <p>Från <%= new DecimalFormat("0").format(product.getPrice()) %> kr</p>
                </span>
            </a>
        </div>
        <%
                }
            }
        %>
    </div>
</div>

<script>
    function getBrightness(image) {
        const canvas = document.createElement('canvas');
        const ctx = canvas.getContext('2d');
        ctx.drawImage(image, 0, 0);
        const imageData = ctx.getImageData(0, 0, image.width, image.height);
        let sum = 0;
        for (let i = 0; i < imageData.data.length; i += 4) {
            sum += imageData.data[i] + imageData.data[i + 1] + imageData.data[i + 2];
        }
        return sum / (imageData.data.length / 3); // Brightness value (0-255)
    }

    function setTextColor(img, index) {
        const productText = document.getElementById('productText' + index);
        const brightness = getBrightness(img);
        productText.style.color = brightness > 100.5 ? 'black' : 'white'; // Adjust the threshold as needed
    }
</script>

</body>

</html>
