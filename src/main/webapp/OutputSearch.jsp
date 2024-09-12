<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		ResultSet rs = (ResultSet)request.getAttribute("rs");
	%>
	
	<h2>List Products</h2>
	
	<table border="1">
	
		<tr>
			<th>Product Name</th>
			<th>Price</th>
			<th>Category</th>
			<th>Quantity</th>
		</tr>
	
	<%
		while(rs.next())
			{		
				String productName = rs.getString("productName");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				int qty = rs.getInt("qty");
				
				out.println("<tr>");
				out.print("<td>" + productName + "</td>");
				out.print("<td>" + price + "</td>");
				out.print("<td>" + category + "</td>");
				out.print("<td>" + qty + "</td>");

				out.print("</tr>");
			}
	%>
				
		</table>

</body>
</html>