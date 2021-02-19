<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product List</title>
</head>
<body>
	<spring:url value="/save" var="saveURL"/>
	<form action="${saveURL}" method="post">
		Name : <input type="text" name="name"> <br><br>
		Brand : <input type="text" name="brand"> <br><br>
		MadeIn : <input type="text" name="made"> <br><br>
		Price : <input type="number" name="price"> <br><br>
		Phone : <input type="tel" name="phone"> <br><br>
		 <input type="submit" value="save"> <br><br>
	</form>		 

</body>
</html>