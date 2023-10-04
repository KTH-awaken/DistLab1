<%--
  Created by IntelliJ IDEA.
  User: hamadaaljarrah
  Date: 2023-10-02
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product form</title>
    <style ><jsp:directive.include file="styles.css"/></style>

</head>
<body class="page">
<jsp:include page="navbar.jsp"></jsp:include>

<div class="form-container">
    <div class="product-form-container" >
        <br>
        <%--  Show alert--%>
        <%if(request.getAttribute("alert") != null) {%>
        <%=request.getAttribute("alert")%>
        <%}%>
        <form class="product-form" action="admin/add-product" method="post" enctype="multipart/form-data">
                <label for="file-upload" class="drop-container" id="dropcontainer">
                    <span class="drop-title">Ladda upp bild</span>
                    eller
                    <div class="file-upload-container">
                        <input type="file" id="file-upload" accept="image/*" required style="display: block">
                    </div>
                </label>
            <div class="coolinput" style="justify-content: space-between">
                <input type="text" placeholder="Produkt namn" name="name" id="name"class="input"style="padding-bottom: 40px">
                <input type="text" placeholder="Antal" name="antal" id="quantity" class="input"style="padding-bottom: 40px">
                <input type="text" placeholder="Pris" name="pris" id="price" class="input"style="padding-bottom: 40px">

            </div>
        </form>
    </div>
        <div class="coolinput"style="width: 637px;">
            <input type="text"  placeholder="Beskrivning" name="description" id="description" class="input"style="padding-bottom: 200px;vertical-align: top">
            <a type="submit" class="button1" style="margin-top: 10px">Lägg till produkt</a>
        </div>
</div>

</body>
</html>
