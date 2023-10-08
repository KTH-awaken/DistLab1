<%@ page import="com.example.distlab1.UI.DTOs.OrderDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Pack Orders</title>
    <style><jsp:directive.include file="styles.css" /></style>
</head>

<body class="page">
<jsp:include page="navbar.jsp"></jsp:include>

<div class="parent">
    <h1 style="font-size: 30px; margin-top: 100px">Orders to Pack</h1>
    <br>

    <!-- Form to show orders -->
    <form action="/pack" method="get">
        <button type="submit" class="button1"style="margin-bottom: 80px">Show Orders</button>
    </form>

<%--    <div>--%>
<%--        <%--%>
<%--            Object data = request.getAttribute("orders");--%>
<%--            if (data != null) {--%>
<%--                ArrayList<OrderDTO> orders = (ArrayList<OrderDTO>) data;--%>
<%--                for (OrderDTO order : orders) {--%>
<%--        %>--%>
<%--        <div class="product-text2">--%>
<%--            Order ID: <%= order.getId() %> | User ID: <%= order.getUserId() %> | Fulfillment status <%= order.isFulfilled() %>--%>
<%--        </div>--%>
<%--        <% } } %>--%>
<%--    </div>--%>
    <div>
        <%
            Object data = request.getAttribute("orders");
            if (data != null) {
                ArrayList<OrderDTO> orders = (ArrayList<OrderDTO>) data;
                for (OrderDTO order : orders) {
        %>
        <div class="orders-to-pack">
            Order ID: <%= order.getId() %> User ID: <%= order.getUserId() %>
            Status: <%= order.isFulfilled() ? "Fulfilled" : "Unfulfilled" %>
            <% if (!order.isFulfilled()) { %>
<%--            <button onclick="packOrder(<%= order.getId() %>"class="pack-btn" >Pack</button>--%>
            <form action="pack?id=<%=order.getId()%>"method="post">
                <button type="submit">
                    <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#000000" style="vertical-align: middle;">
                        <path d="M0 0h24v24H0z" fill="none"/>
                        <path d="M20 8h-3V4H3c-1.1 0-2 .9-2 2v11h2c0 1.66 1.34 3 3 3s3-1.34 3-3h6c0 1.66 1.34 3 3 3s3-1.34 3-3h2v-5l-3-4zM6 18.5c-.83 0-1.5-.67-1.5-1.5s.67-1.5 1.5-1.5 1.5.67 1.5 1.5-.67 1.5-1.5 1.5zm13.5-9l1.96 2.5H17V9.5h2.5zm-1.5 9c-.83 0-1.5-.67-1.5-1.5s.67-1.5 1.5-1.5 1.5.67 1.5 1.5-.67 1.5-1.5 1.5z"/>
                    </svg>

                </button>
            </form>
            <% } %>
        </div>
        <%
                }
            }
        %>
    </div>
</div>

</body>
</html>
