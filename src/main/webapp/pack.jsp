<%@ page import="com.example.distlab1.UI.DTOs.OrderDTO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Marcus
  Date: 2023-10-06
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body class="page">
<jsp:include page="navbar.jsp"></jsp:include>
      <h1>Orders to pack</h1>

  <div class="parent">
      <% Object data=request.getAttribute("orders");
          ArrayList<OrderDTO> orders = (ArrayList<OrderDTO>) data;%>
<%--      <div class="layout-container">--%>
<%--          <h1 class="mb-8 text-2xl font-bold">Handle orders</h1>--%>

<%--          <div class="flex flex-col gap-4">--%>
<%--              <% for (OrderDTO order:orders) {%>--%>

<%--                  <div class="flex-1 mt-2">--%>
<%--                      <h1>ID:  <%=order.getId()%></h1>--%>
<%--                      <p>USER ID <%=order.getUserId()%></p>--%>
<%--                  </div>--%>
<%--                  <div class="flex items-center gap-8">--%>
<%--                      <form action="order-details?id=<%=order.getId()%>" method="get">--%>
<%--                          <button type="submit">--%>
<%--                              <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" viewBox="0 0 26 26">--%>
<%--                                  <path--%>
<%--                                          d="M.2 10a11 11 0 0 1 19.6 0A11 11 0 0 1 .2 10zm9.8 4a4 4 0 1 0 0-8 4 4 0 0 0 0 8zm0-2a2 2 0 1 1 0-4 2 2 0 0 1 0 4z" />--%>
<%--                              </svg>--%>
<%--                          </button>--%>
<%--                      </form>--%>

<%--                      <form action="edit-order?id=<%=order.getId()%>" method="post">--%>
<%--                          <button type="submit">--%>
<%--                              <svg width="24" height="24" stroke-width="1.5" viewBox="0 0 24 24" fill="none"--%>
<%--                                   xmlns="http://www.w3.org/2000/svg">--%>
<%--                                  <path--%>
<%--                                          d="M13.0207 5.82839L15.8491 2.99996L20.7988 7.94971L17.9704 10.7781M13.0207 5.82839L3.41405 15.435C3.22652 15.6225 3.12116 15.8769 3.12116 16.1421V20.6776H7.65669C7.92191 20.6776 8.17626 20.5723 8.3638 20.3847L17.9704 10.7781M13.0207 5.82839L17.9704 10.7781"--%>
<%--                                          stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" />--%>
<%--                              </svg>--%>
<%--                          </button>--%>
<%--                      </form>--%>

<%--                      <form action="delete-order?id=<%=order.getId()%>" method="post">--%>
<%--                          <button type="submit">--%>
<%--                              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">--%>
<%--                                  <g>--%>
<%--                                      <path fill="none" d="M0 0h24v24H0z" />--%>
<%--                                      <path--%>
<%--                                              d="M17 6h5v2h-2v13a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V8H2V6h5V3a1 1 0 0 1 1-1h8a1 1 0 0 1 1 1v3zm1 2H6v12h12V8zM9 4v2h6V4H9z" />--%>
<%--                                  </g>--%>
<%--                              </svg>--%>
<%--                          </button>--%>
<%--                      </form>--%>
<%--                  </div>--%>
<%--              </div>--%>
<%--              <%}%>--%>
<%--          </div>--%>
<%--      </div>--%>
  </div>

</body>
</html>
