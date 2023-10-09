<%@ page import="com.example.distlab1.UI.DTOs.ProductDTO" %><%--
  Created by IntelliJ IDEA.
  User: hamadaaljarrah
  Date: 2023-10-09
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
    <style><jsp:directive.include file="styles.css" /></style>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <section class="layout-container">
        <%ProductDTO product = (ProductDTO) request.getAttribute("product");%>
        <h1 class="font-bold text-3xl mb-8">Edit product</h1>
        <p><strong>ID: </strong><%=product.getId()%></p>
        <p><strong>Namn: </strong><%=product.getName()%></p>
        <p><strong>pris: </strong>kr <%=product.getPrice()%></p>
        <div class="my-3 border-b-[0.5px] border-[#c9c9c9]"></div>


        <div class="flex justify-center pt-12">
            <div class="product-form-container">
                <form action="/admin/edit-product" method="post" enctype="multipart/form-data">
                    <div class="product-form">
                        <input  type="text" value="<%=product.getId()%>" name="id" id="id" class="hidden">
                        <label for="file-upload" class="drop-container" id="dropcontainer">

                            <span class="drop-title">Ladda upp bild</span>
                            eller
                            <div class="file-upload-container">
                                <input  type="file" name="image" id="file-upload" accept="image/*" required style="display: block">
                            </div>
                        </label>
                        <div class="coolinput" style="justify-content: space-between">
                            <input value="<%=product.getName()%>" type="text" placeholder="Produkt namn" name="name" id="name"
                                   class="input" style="padding-bottom: 40px">
                            <input value="<%=product.getQuantity()%>"  type="text" placeholder="Antal" name="quantity" id="quantity"
                                   class="input" style="padding-bottom: 40px">
                            <input value="<%=Math.round(product.getPrice())%>"  type="text" placeholder="Pris" name="price" id="price"
                                   class="input" style="padding-bottom: 40px">
                        </div>
                    </div>
                    <div class="coolinput" style="width: 637px;margin-top: 10px">
                        <input value="<%=product.getDescription()%>"  type="text" placeholder="Beskrivning" name="description"
                               id="description" class="input"
                               style="padding-bottom: 200px;vertical-align: top">
                        <button type="submit" class="button1" style="margin-top: 10px">Updatera  produkt</button>
                    </div>
                </form>
            </div>
        </div>


    </section>



</body>
</html>
