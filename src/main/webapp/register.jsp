<%--
  Created by IntelliJ IDEA.
  User: Marcus
  Date: 2023-10-04
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style ><jsp:directive.include file="styles.css"/></style>
</head>
<body>
<div class="page">
    <jsp:include page="navbar.jsp"></jsp:include>
    <div class="welcome-text">
        <h2>
            <span>Skapa konto.</span>
        </h2>
    </div>
    <div class="form-container">
        <br>
        <%--  Show alert--%>
        <%if(request.getAttribute("alert") != null) {%>
        <%=request.getAttribute("alert")%>
        <%}%>
        <form class="form">
            <div class="coolinput">
                <input type="text" placeholder="Användarnamn" name="input" class="input">
                <input type="text" placeholder="E-postadress" name="input" class="input">
                <input type="text" placeholder="Lösenord" name="input" class="input">
                <a href="products" class="button1">Skapa konto</a>
            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>
