<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
table, th, td {
  border: 1px solid black;
}
</style>

</head>
<body>
	<h3>Product List</h3>
	<table>
		<thead>
			<tr>
		<!-- 	<th>Product ID</th>  	-->
				<th>Name</th>
				<th>Brand</th>
				<th>Made In</th>
				<th>Price</th>
				<th>Phone</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${search_List}" var="product">
				<tr>
			<!-- 	<td>${product.id}</td> 	-->
					<td>${product.name}</td>
					<td>${product.brand}</td>
					<td>${product.made}</td>
					<td>${product.price}</td>
					<td>${product.phone}</td>
					<td><a href="edit/${product.id}">Edit</a></td>
					<td><a href="delete/${product.id}">Delete</a></td>
				</tr>
			</c:forEach>	
			
		</tbody>		
	</table>		
</body>
</html>