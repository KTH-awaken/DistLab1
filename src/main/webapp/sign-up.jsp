<%--
  Created by IntelliJ IDEA.
  User: hamadaaljarrah
  Date: 2023-10-03
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
     <link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body class="page">
  <%--  Show alert--%>
  <%if(request.getAttribute("alert") != null) {%>
    <%=request.getAttribute("alert")%>
  <%}%>
  <form action="/sign-up" method="post">
      <div>
        <label for="username">Username</label>
        <input type="text" name="username" id="username"/>
      </div>
    <div>
      <label for="email">Email</label>
      <input type="email" name="email" id="email"/>
    </div>
    <div>
      <label for="password">Password</label>
      <input type="password" name="password" id="password"/>
    </div>
    <button type="submit">Register</button>
  </form>
</body>
</html>
