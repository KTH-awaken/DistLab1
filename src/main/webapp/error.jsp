<%-- Created by IntelliJ IDEA. User: hamadaaljarrah Date: 2023-10-03 Time: 20:52 To change this template use File |
    Settings | File Templates. --%>
    <%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <title>Error</title>
            <style><jsp:directive.include file="styles.css" /></style>
            <script src="https://cdn.tailwindcss.com"></script>
        </head>

        <body>
            <section class="layout-container">
                <div class="m-auto mt-20 flex w-fit max-w-[500px] flex-col items-center justify-start gap-4 rounded-xl p-8 shadow-md">
                    <img class="h-52" src="https://cdn-icons-png.flaticon.com/512/5219/5219070.png" />
                    <div class="flex flex-col gap-4">
                        <h1 class="text-xl font-bold">Error</h1>
                        <code class="mb-2"><%=request.getAttribute("errorMessage")%></code>
                        <a href="/" class="w-full rounded-lg bg-blue-500 px-4 py-2 text-white shadow-md">Go back</a>
                    </div>
                </div>

            </section>

        </body>

        </html>