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
</head>
<body>


    <form action="add-product" method="post" enctype="multipart/form-data">
        <div>
            <label for="name">Name</label>
            <input type="text" name="name" id="name"/>
        </div>
        <div>
            <label for="description">Description</label>
            <input type="text" name="description" id="description"/>

        </div>
        <div>
            <label for="quantity">Quantity</label>
            <input type="number" name="quantity" id="quantity"/>

        </div>
        <div>
            <label for="price">Price</label>
            <input type="number" name="price" id="price"/>
        </div>
        <div>
            <label for="image">Image</label>
            <input type="file" name="image" id="image"/>

        </div>
        <button type="submit">Add product</button>
    </form>
</body>
</html>
