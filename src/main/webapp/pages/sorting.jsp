<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sorting Product</title>

<style>
table, th, td {
  border: 1px solid #411655;
}
</style>
</head>
<body>
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
			<c:forEach items="${lists}" var="sort">
				<tr>
					<!--     <td>${product.id}</td>  -->
					<td>${sort.name}</td>
					<td>${sort.brand}</td>
					<td>${sort.made}</td>
					<td>${sort.price}</td>
					<td>${sort.phone}</td>
					<td><a href="edit/${sort.id}">Edit</a></td>
					<td><a href="delete/${sort.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>	
	<ul class="pagination">
		<li><a href="sorting/5">&lt;</a></li>
		<li><a href="sorting/0">1</a></li>
		<li><a href="sorting/1">2</a></li>
		<li><a href="sorting/2">3</a></li>
		<li><a href="sorting/3">4</a></li>
		<li><a href="sorting/4">5</a></li>	
		<li><a href="sorting/0">&gt;</a></li>
	</ul>	
</body>
</html>