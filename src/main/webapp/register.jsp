<%-- Created by IntelliJ IDEA. User: Marcus Date: 2023-10-04 Time: 16:09 To change this template use File | Settings |
    File Templates. --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <title>Login</title>
            <style>
                <jsp:directive.include file="styles.css" />
            </style>
        </head>

        <body class="page">
            <jsp:include page="navbar.jsp"></jsp:include>
            <div class="layout-container">
                <div class="welcome-text">
                    <h2>
                        <span>Skapa konto.</span>
                    </h2>
                </div>
                <div class="form-container">
                    <br>
                    <%-- Show alert--%>
                        <%if(request.getAttribute("alert") !=null) {%>
                            <%=request.getAttribute("alert")%>
                                <%}%>
                                    <form class="form" method="post" action="/sign-up">
                                        <div class="coolinput" style="gap: 10px">
                                            <input type="text" placeholder="Användarnamn" name="username" id="username"
                                                class="input">
                                            <input type="text" placeholder="E-postadress" name="email" id="email"
                                                class="input">
                                            <input type="text" placeholder="Lösenord" name="password" id="password"
                                                class="input">
                                            <button type="submit" class="button1">Skapa konto</button>
                                        </div>
                                    </form>

                </div>
            </div>
        </body>

        </html>