<%@ page import="java.util.ArrayList" %>
    <%@ page import="com.example.distlab1.UI.DTOs.ProductDTO" %>
<%@ page import="com.example.distlab1.UI.DTOs.UserDTO" %><%-- Created by IntelliJ IDEA. User: Marcus Date:
            2023-10-02 Time: 18:40 To change this template use File | Settings | File Templates. --%>
            <%@ page contentType="text/html;charset=UTF-8" language="java" %>
                <html>

                <head>
                    <title>Title</title>
                    <link rel="stylesheet" type="text/css" href="styles.css">
                    <script src="https://cdn.tailwindcss.com"></script>
                </head>

                <body>
                <% UserDTO user = (UserDTO)session.getAttribute("user");%>

                    <div class="layout-container">
                        <div class="topnav ">
                            <div>
                                <a class="<%= request.getRequestURI().endsWith(" index.jsp") ? "active" : "" %>" href="/">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                    class="bi bi-apple" viewBox="0 0 16 16">
                                    <path
                                        d="M11.182.008C11.148-.03 9.923.023 8.857 1.18c-1.066 1.156-.902 2.482-.878 2.516.024.034 1.52.087 2.475-1.258.955-1.345.762-2.391.728-2.43Zm3.314 11.733c-.048-.096-2.325-1.234-2.113-3.422.212-2.189 1.675-2.789 1.698-2.854.023-.065-.597-.79-1.254-1.157a3.692 3.692 0 0 0-1.563-.434c-.108-.003-.483-.095-1.254.116-.508.139-1.653.589-1.968.607-.316.018-1.256-.522-2.267-.665-.647-.125-1.333.131-1.824.328-.49.196-1.422.754-2.074 2.237-.652 1.482-.311 3.83-.067 4.56.244.729.625 1.924 1.273 2.796.576.984 1.34 1.667 1.659 1.899.319.232 1.219.386 1.843.067.502-.308 1.408-.485 1.766-.472.357.013 1.061.154 1.782.539.571.197 1.111.115 1.652-.105.541-.221 1.324-1.059 2.238-2.758.347-.79.505-1.217.473-1.282Z" />
                                    <path
                                        d="M11.182.008C11.148-.03 9.923.023 8.857 1.18c-1.066 1.156-.902 2.482-.878 2.516.024.034 1.52.087 2.475-1.258.955-1.345.762-2.391.728-2.43Zm3.314 11.733c-.048-.096-2.325-1.234-2.113-3.422.212-2.189 1.675-2.789 1.698-2.854.023-.065-.597-.79-1.254-1.157a3.692 3.692 0 0 0-1.563-.434c-.108-.003-.483-.095-1.254.116-.508.139-1.653.589-1.968.607-.316.018-1.256-.522-2.267-.665-.647-.125-1.333.131-1.824.328-.49.196-1.422.754-2.074 2.237-.652 1.482-.311 3.83-.067 4.56.244.729.625 1.924 1.273 2.796.576.984 1.34 1.667 1.659 1.899.319.232 1.219.386 1.843.067.502-.308 1.408-.485 1.766-.472.357.013 1.061.154 1.782.539.571.197 1.111.115 1.652-.105.541-.221 1.324-1.059 2.238-2.758.347-.79.505-1.217.473-1.282Z" />
                                </svg>
                                </a>
                            </div>
                            <div class="flex gap-4">
                                <%if(user == null || user.getRole().compareTo("customer") == 0){%>
                                <a class="<%= request.getRequestURI().endsWith(" index.jsp") ? "active" : "" %>"
                                    href="/">Hem</a>
                                <%}%>
                                <%if(user == null || user.getRole().compareTo("customer") == 0){%>
                                <a class="<%= request.getRequestURI().endsWith(" products") ? "active" : "" %>"
                                    href="/products">Produkter</a>
                                <%}%>
<%--                                Admin Access--%>

                                <%if(user != null){%>
                                <%if (user.getRole().compareTo("admin") == 0) {%>
                                <a class="<%= request.getRequestURI().endsWith(" admin/add-product") ? "active" : "" %>"
                                    href="/admin/add-product">Lägg till produkt</a>
                                <%}%>
                                <%}%>

<%--                            Edit Button--%>
                                <%if(user != null){%>
                                <%if (user.getRole().compareTo("admin") == 0) {%>
                                <a class="<%= request.getRequestURI().endsWith(" admin/handle-products") ? "active" : "" %>"
                                   href="/admin/handle-products">Radigera produkter</a>
                                <%}%>
                                <%}%>

                                <%if(user != null){%>
                                <%if (user.getRole().compareTo("warehouse") == 0) {%>
                                <a class="<%= request.getRequestURI().endsWith(" warehouse/handle-order") ? "active" : "" %>"
                                   href="/pack.jsp">Hantera beställningar</a>
                                <%}%>
                                <%}%>


                            </div>

                            <div class="flex ">
<%--                                Login Button--%>
                                <%if(user == null){%>
                                <a class=" <%= request.getRequestURI().endsWith(" login") ? "active" : "" %>"
                                   href="/login">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                         fill="none" stroke="#000000" stroke-width="2" stroke-linecap="round"
                                         stroke-linejoin="round">
                                        <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
                                        <circle cx="12" cy="7" r="4"></circle>
                                    </svg>

                                </a>
                                <%}%>

<%--                                Logout Button--%>


                                    <%if(user != null){%>
                                    <form action="/logout" method="post">

                                    <button type="submit">
                                        <a href="">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-log-out"><path d="M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4"></path><polyline points="16 17 21 12 16 7"></polyline><line x1="21" y1="12" x2="9" y2="12"></line></svg>
                                        </a>
                                        <%}%>
                                    </button>
                                    </form>


<%--                                Cart Button--%>
                                <div class="relative" >
                                    <%if(user == null || user.getRole().compareTo("customer") == 0){%>
                                    <a class="relative  <%= request.getRequestURI().endsWith("cart") ? "active" : "" %>
                                        " href="/cart">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                            viewBox="0 0 24 24" fill="none" stroke="#000000" stroke-width="2"
                                            stroke-linecap="round" stroke-linejoin="round">
                                            <circle cx="10" cy="20.5" r="1" />
                                            <circle cx="18" cy="20.5" r="1" />
                                            <path
                                                d="M2.5 2.5h3l2.7 12.4a2 2 0 0 0 2 1.6h7.7a2 2 0 0 0 2-1.6l1.6-8.4H7.1" />
                                        </svg>
                                    </a>
                                    <%}%>
                                    <%if (session.getAttribute("numOfCartItems") !=null) {%>
                                        <p
                                            class="absolute right-0 flex justify-center items-center text-sm text-white w-[20px] h-[20px] rounded-full z-10 bg-blue-500">
                                            <%=session.getAttribute("numOfCartItems")%>
                                        </p>
                                        <%}%>
                                </div>

                            </div>


                        </div>

                    </div>

                </body>

                </html>