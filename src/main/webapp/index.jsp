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
            </head>

            <body class="page">
                <jsp:include page="navbar.jsp"></jsp:include>

                <div class="layout-container">
                    <div class="welcome-text">
                        <h2>
                            Store.<span style="color: #6e6e73"> Det bästa stället att <br />
                                köpa dina favoritprodukter.</span>
                        </h2>
                    </div>
                    <%-- <button href="products">Shop now</button>--%>
                        <div class="buttonPlacement1">
                            <a href="products" class="button2">Shop now</a>
                        </div>

                </div>

            </body>

            </html>