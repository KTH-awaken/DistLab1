<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style ><jsp:directive.include file="styles.css"/></style>
</head>
<body class="page">
<jsp:include page="navbar.jsp"></jsp:include>
<div class="welcome-text">
    <h2>
        <span>Logga in för snabbare betalning.</span>
    </h2>
</div>
<div class="form-container">
    <br>
    <%--  Show alert--%>
    <%if(request.getAttribute("alert") != null) {%>
    <%=request.getAttribute("alert")%>
    <%}%>
    <form action="/login" method="post" class="form">
        <div class="coolinput" style="gap: 10px">
            <input type="text" placeholder="E-postadress" name="email" id="email" class="input">
            <input type="password" placeholder="Lösenord" name="password" id="password"  class="input">
            <button type="submit" href="products" class="button1">Logga in</button>
        </div>
        <p class="message">Har du inget konto? <a href="register.jsp">Skapa ett eget nu</a></p>
    </form>
</div>
</body>
</html>