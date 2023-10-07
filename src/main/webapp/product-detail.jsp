<%@ page import="com.example.distlab1.UI.DTOs.ProductDTO" %><%-- Created by IntelliJ IDEA. User: hamadaaljarrah Date:
        2023-10-02 Time: 22:59 To change this template use File | Settings | File Templates. --%>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.tailwindcss.com"></script>
<style>
    <jsp:directive.include file="styles.css" />
</style>

<html>

<head>
    <title>Product detail</title>
</head>

<body class="page">
    <jsp:include page="navbar.jsp"></jsp:include>
    <% Object data=request.getAttribute("product"); ProductDTO product=(ProductDTO) data; %>
        <div class="max-w-[1200px] h-screen  pt-[50px] px-2 m-auto">
            <div class="flex h-full justify-between ">
                <img class="w-[49%] h-[60%]  object-cover rounded-3xl "
                    src="data:image/jpg;base64,<%=product.getBase64Image()%>" alt="" style="box-shadow: 0 4px 14px 0 rgb(0 0 0 / 10%);">
                <div
                    class="w-[49%] aspect-square flex flex-col justify-start gap-10 max-screen overflow-auto">
                    <h2 class="font-bold text-4xl">
                        <%= product.getName()%>
                    </h2>
                    <div>
                        <h3 class="font-semibold text-xl">Stock</h3>
                        <span class="font-light text-2xl">
                            <%= product.getQuantity()%>
                        </span>
                        <span class="text-xs">Pieces Avalibal in Stock</span>
                        <span class="w-[10px] h-[10px] inline-block bg-blue-500 rounded-full"></span>
                    </div>
                    <div>
                        <h3 class="font-semibold text-xl mb-3">Description</h3>
                        <p class="font-light  text-md leading-6">
                            <%= product.getDescription()%>
                        </p>
                    </div>
                    <div>
                        <h3 class="font-semibold text-xl">Price</h3>
                        <span class="font-light text-2xl">
                            <%= product.getPrice()%> Kr
                        </span>
                        <span class="text-xs">varav <%= Math.floor(product.getPrice() * 0.2)%> kr moms
                                25%</span>
                    </div>
                    <form action="/add-to-cart?id=<%=product.getId()%>" method="post">
                        <button type="submit" class="bg-[#222222] text-white w-full p-2 rounded-lg">ADD TO
                            CART</button>
                    </form>
                </div>
            </div>
        </div>
</body>
</html>