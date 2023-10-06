<%@ page import="com.example.distlab1.BO.Entities.Product" %>
    <%@ page import="java.util.ArrayList" %>
        <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>

                <title>JSP - Hello World</title>
                <%-- <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/styles.css">--%>
                    <style>
                        <jsp:directive.include file="styles.css" />
                    </style>
                <script src="https://cdn.tailwindcss.com"></script>

            </head>

            <body class="page">
            <jsp:include page="navbar.jsp"></jsp:include>

                <div class="layout-container">
                    <div class="flex justify-between items-center mt-[200px]">
                        <div class="flex flex-col  items-start gap-8 ">
                            <h2 class="text-5xl">
                                Store.<span style="color: #6e6e73"> Det bästa stället att <br />
                                    köpa dina favoritprodukter.</span>
                            </h2>
                            <a href="products">
                                <button class="px-6 py-3 bg-[#333333] text-white rounded-lg">Shoppa nu</button>
                            </a>
                        </div>
                        <div class="w-1/2 ">
<%--                            <img class="absolute top-1/2 object-cover w-full rounded-3xl" src="https://www.apple.com/newsroom/images/product/mac/standard/Apple_MacBook-Pro_14-16-inch_10182021_big.jpg.large.jpg" alt="macbook">--%>
                            <img class="object-cover w-full rounded-3xl" src="https://www.apple.com/v/iphone/home/bp/images/meta/iphone__ky2k6x5u6vue_og.png">
                        </div>
                    </div>
                    <%-- <button href="products">Shop now</button>--%>


                </div>

            </body>

            </html>