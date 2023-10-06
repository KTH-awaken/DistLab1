<%-- Created by IntelliJ IDEA. User: hamadaaljarrah Date: 2023-10-03 Time: 20:52 To change this template use File |
    Settings | File Templates. --%>
    <%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <title>Error</title>
        </head>

        <body>
            <h1>Error</h1>
            <p>
                <%=request.getAttribute("errorMessage")%>
            </p>
            <a href="<%=request.getAttribute(" try-url")%>">Try again</a><br />
            <a href="/">Go back</a>

        </body>

        </html>