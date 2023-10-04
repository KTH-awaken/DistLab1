<%--
  Created by IntelliJ IDEA.
  User: hamadaaljarrah
  Date: 2023-10-03
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script src="https://cdn.tailwindcss.com"></script>

</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

    <%--  Show alert--%>
    <%if(request.getAttribute("alert") != null) {%>
    <%=request.getAttribute("alert")%>
    <%}%>
    <form action="/login" method="post">
        <div>
            <label for="email">Email</label>
            <input type="email" name="email" id="email"/>
        </div>
        <div>
            <label for="password">Password</label>
            <input type="password" name="password" id="password"/>
        </div>
        <button type="submit">Login</button>
    </form>
<p>Login</p>
</body>
</html>
