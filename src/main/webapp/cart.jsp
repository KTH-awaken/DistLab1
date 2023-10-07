<%@ page import="com.example.distlab1.UI.DTOs.ProductDTO" %>
    <%@ page import="java.util.ArrayList" %><%-- Created by IntelliJ IDEA. User: hamadaaljarrah Date: 2023-10-04 Time:
            22:43 To change this template use File | Settings | File Templates. --%>
            <%@ page contentType="text/html;charset=UTF-8" language="java" %>
                <script src="https://cdn.tailwindcss.com"></script>
                <style>
                    <jsp:directive.include file="styles.css" />
                </style>

                <html>

                <head>
                    <title>Cart</title>
                </head>

                <body>

                    <jsp:include page="navbar.jsp"></jsp:include>


                    <div class="layout-container">

                        <div class="flex flex-col h-screen py-4">
                            <h1 class="font-bold text-3xl mb-4">My Cart</h1>
                            <div class="p-4 flex-1 overflow-scroll" style="max-height: 80%">

                                <% Object data=session.getAttribute("cart"); if (data !=null) { ArrayList<ProductDTO>
                                    products =
                                    (ArrayList<ProductDTO>) data;
                                        for (ProductDTO product : products) {
                                        %>
                                        <div class="border-b-[0.5px] border-black  flex gap-4 pb-3 mb-2">
                                            <img class="w-24 h-24 object-cover rounded-md"
                                                src="data:image/jpg;base64,<%=product.getBase64Image()%>"
                                                alt="<%=product.getName()%>">

                                            <div class="flex-1 flex justify-between items-center pr-5">
                                                <div class="self-start flex flex-col gap-2">
                                                    <h3>
                                                        <%=product.getName()%>
                                                    </h3>
                                                    <p>$ <%=product.getPrice()%>
                                                    </p>
                                                </div>
                                                <form action="/remove-from-cart?id=<%=product.getId()%>" method="post">
                                                    <button type="submit" class="p-2">
                                                        X
                                                    </button>
                                                </form>
                                            </div>
                                        </div>

                                        <% } } %>
                            </div>

                            <form action="place-order" method="post">
                                <button class="w-full bg-[#222222] p-2 rounded-md text-white">Place order</button>
                            </form>
                        </div>

                    </div>


                </body>

                </html>