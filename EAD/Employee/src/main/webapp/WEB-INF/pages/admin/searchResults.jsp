<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>Search Results</title>
</head>
<body>
	<h1>Search Results</h1>
	
	<table>
		<tr>
			<th>Name</th>
			<th></th>
		</tr>
		<c:if test="${not empty result}">
		   	<c:forEach items="${result}" var="employee">
		    	<tr>
		    		<td>${employee.firstName} ${employee.middleName} ${employee.lastName}</td>
		    		<td></td>
		    		<td><a href="viewEmployee?employeeCode=${employee.employeeCode}">View</a></td>
		    		<td><a href="editEmployee?employeeCode=${employee.employeeCode}">Edit</a></td>
		    	</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>