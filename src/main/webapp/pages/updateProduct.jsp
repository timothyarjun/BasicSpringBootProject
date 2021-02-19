<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update Product </title>
</head>
<body>
		<h2>Update Product Details</h2>
		<spring:url value="/update" var="editProduct" />
		<form action="${editProduct}" method="Post">
		Product_Id :<input type="number" name="id" value="${product.id}" readonly="readonly"/> <br><br>
		Name : <input type="text" name="name" value="${product.name}" /> <br><br>
		Brand : <input type="text" name="brand" value="${product.brand}" /> <br><br>
		MadeIn : <input type="text" name="made" value="${product.made}" /> <br><br>
		Price : <input type="number" name="price" value="${product.price}" /> <br><br>
		Phone : <input type="tel" name="phone" value="${product.phone}" /> <br><br>
		 <input type="submit" value="Save"> <br><br>
	</form>
</body>
</html>