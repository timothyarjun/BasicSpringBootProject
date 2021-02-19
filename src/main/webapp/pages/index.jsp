<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home page of the product</title>
 <style>
table, th, td {
  border: 1px solid #411655;
}
</style>
</head>
<body>
	<h1>Product Manager</h1>
	<table>
		<tr>
			<td><span><a href="add">Add New Product</a></span></td>
			<td><spring:url value="/search" var="searchProduct" />
				<form action="${searchProduct}" method="get" autocomplete="off">
					<input type="text" name="search" /> <input type="submit" value="search" />
				</form>
			</td>
		</tr>
	</table>

	<table>
		<thead>
			<tr>
				<!--  	<td>Product ID</td> -->
				<td>Name</td>
				<td>Brand</td>
				<td>Made In</td>
				<td>Price</td>
				<td>Phone</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${listProduct}" var="product">
				<tr>
					<!--     <td>${product.id}</td>  -->
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