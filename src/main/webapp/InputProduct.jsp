<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Product</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #e9ecef;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    h2 {
        color: #343a40;
        text-align: center;
        margin-bottom: 20px;
    }

    form {
        background-color: #fff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
    }

    label {
        font-weight: 600;
        color: #495057;
        margin-bottom: 5px;
        display: inline-block;
    }

    input[type="text"] {
        width: calc(100% - 22px); /* Adjusting for padding and border */
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ced4da;
        border-radius: 5px;
        font-size: 16px;
        transition: border-color 0.3s;
    }

    input[type="text"]:focus {
        border-color: #80bdff;
        outline: none;
    }

    .error {
        color: #e74c3c;
        font-size: 14px;
        margin-top: -10px;
        margin-bottom: 10px;
        display: block;
    }

    input[type="submit"] {
        background-color: #28a745;
        color: white;
        border: none;
        padding: 12px 0;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        width: 100%;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #218838;
    }

</style>
</head>
<body>

	<h2>Add New Product</h2>

<% 	
    String productNameError = (String)request.getAttribute("productNameError");
    String priceError = (String)request.getAttribute("priceError");
    String categoryError = (String)request.getAttribute("categoryError");
    String qtyError = (String)request.getAttribute("qtyError");
%>


<form action="SaveProductServlet" method="post">
    
    <div class="form-group">
        <label for="productName">Product Name:</label>
        <input type="text" id="productName" name="productName"/>
        <span class="error"><%= productNameError == null ? "" : productNameError %></span>
    </div>

    <div class="form-group">
        <label for="price">Price:</label>
        <input type="text" id="price" name="price"/>
        <span class="error"><%= priceError == null ? "" : priceError %></span>
    </div>

    <div class="form-group">
        <label for="category">Category:</label>
        <input type="text" id="category" name="category"/>
        <span class="error"><%= categoryError == null ? "" : categoryError %></span>
    </div>

    <div class="form-group">
        <label for="qty">Qty:</label>
        <input type="text" id="qty" name="qty"/>
        <span class="error"><%= qtyError == null ? "" : qtyError %></span>
    </div>

    <input type="submit" value="Add Product">

</form>
</body>
</html>
